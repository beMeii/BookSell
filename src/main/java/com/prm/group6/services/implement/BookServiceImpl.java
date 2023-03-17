package com.prm.group6.services.implement;

import com.prm.group6.exceptions.BookException;
import com.prm.group6.model.ErrorEnum;
import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.dto.CommentDTO;
import com.prm.group6.model.dto.GenreDTO;
import com.prm.group6.model.dto.ListResponse;
import com.prm.group6.model.entity.Book;
import com.prm.group6.model.entity.BookGenre;
import com.prm.group6.model.entity.Comment;
import com.prm.group6.model.entity.Genre;
import com.prm.group6.repositories.BookGenreRepository;
import com.prm.group6.repositories.BookRepository;
import com.prm.group6.repositories.CommentRepository;
import com.prm.group6.repositories.GenreRepository;
import com.prm.group6.services.BookService;
import com.prm.group6.services.mappers.BookMapper;
import com.prm.group6.services.mappers.CommentMapper;
import com.prm.group6.services.mappers.GenreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    BookGenreRepository bookGenreRepository;
    @Autowired
    CommentRepository commentRepository;

    public ListResponse getBookList(int pageNo, int pageSize) {
        ListResponse listResponse = new ListResponse();
        List<BookDTO> bookDTOList= new ArrayList<>();
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Book> bookList = bookRepository.findAll(pageable);
        bookList.forEach(book -> {
            BookDTO b = BookMapper.INSTANCE.bookToBookDto(book);
            b = getBookGenre(b);
            bookDTOList.add(b);
        });
        listResponse.setListBook(bookDTOList);
        listResponse.setTotalPage(bookList.getTotalPages());
        return listResponse;
    }


    public List<BookDTO> getBookListByGenreId(int genreId) {
        List<BookDTO> bookDTOList = new ArrayList<>();
        List<BookGenre> bookList = bookGenreRepository.findByGenreId(genreId);
        bookList.forEach(bookGenre -> {
            Book book = bookRepository.findByBookId(bookGenre.getBookId());
            BookDTO b = BookMapper.INSTANCE.bookToBookDto(book);
            b = getBookGenre(b);
            bookDTOList.add(b);
        });
        return bookDTOList;
    }

    public ListResponse getBookListByBookNameOrAuthor(String str, int pageNo, int pageSize) {
        ListResponse listResponse = new ListResponse();
        List<BookDTO> bookDTOList = new ArrayList<>();
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Book> bookList = bookRepository.findByTitleContainingOrAuthorContainingIgnoreCase(str, str, pageable);
        bookList.forEach(book -> {
            BookDTO b = BookMapper.INSTANCE.bookToBookDto(book);
            b = getBookGenre(b);
            bookDTOList.add(b);
        });
        listResponse.setListBook(bookDTOList);
        listResponse.setTotalPage(bookList.getTotalPages());
        return listResponse;
    }

    public BookDTO getBookById(int bookId) {
        Book book = bookRepository.findByBookId(bookId);
        BookDTO b = BookMapper.INSTANCE.bookToBookDto(book);
        b = getBookGenre(b);
        List<CommentDTO> commentDTOS = getCommentByBookId(bookId);
        b.setComment(commentDTOS);
        double avg = commentRepository.avg(bookId);
        b.setRating(avg);
        return b;
    }

    public BookDTO getBookGenre(BookDTO bookDTO){
        List<BookGenre> bookGenreList = bookGenreRepository.findByBookId(bookDTO.getBookId());
        List<GenreDTO> genreNames = new ArrayList<>();
        bookGenreList.forEach(bookGenre -> {
            Genre genre = genreRepository.findByGenreId(bookGenre.getGenreId());
            GenreDTO genreDTO = GenreMapper.INSTANCE.genreToGenreDto(genre);
            genreNames.add(genreDTO);
        });
        bookDTO.setGenreName(genreNames);
        return bookDTO;
    }

    public BookDTO addNewBook(BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.bookDtoToBook(bookDTO);
        bookRepository.save(book);
        return bookDTO;
    }

    public BookDTO updateBook(BookDTO bookDTO) {
        Book book = bookRepository.findByBookId(bookDTO.getBookId());
        if (Objects.nonNull(book)){
            book = BookMapper.INSTANCE.bookDtoToBook(bookDTO);
            bookRepository.save(book);
        }else {
            throw new BookException(ErrorEnum.BOOK_NOT_FOUND.getErrorMessage());
        }
        return bookDTO;
    }
    public void deleteBook(int id){
        Book book = bookRepository.findByBookId(id);
        if (Objects.nonNull(book)){
            bookRepository.deleteById(String.valueOf(id));
        }else {
            throw new BookException(ErrorEnum.BOOK_NOT_FOUND.getErrorMessage());
        }
    }

    public BookDTO addComment(CommentDTO commentDTO) {
        Comment comment = CommentMapper.INSTANCE.commentDtoToComment(commentDTO);
        comment.setTimestamp(LocalDateTime.now());
        if (Objects.nonNull(comment.getCommentId())){
            commentRepository.save(comment);
        }
        Book book = bookRepository.findByBookId(comment.getBookId());
        BookDTO bookDTO = new BookDTO();
        if (Objects.nonNull(book)) {
            bookDTO = getBookById(comment.getBookId());
        }else {
            throw new BookException(ErrorEnum.BOOK_NOT_FOUND.getErrorMessage());
        }
        return bookDTO;
    }

    public List<CommentDTO> getCommentByBookId(int bookId){
        List<CommentDTO> commentDTOS = new ArrayList<>();
        List<Comment> comments = commentRepository.findByBookId(bookId);
        comments.forEach(c->{
            CommentDTO commentDTO = CommentMapper.INSTANCE.commentToCommentDto(c);
            commentDTOS.add(commentDTO);
        });
        return commentDTOS;
    }
}
