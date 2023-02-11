package com.prm.group6.services.implement;

import com.prm.group6.exceptions.BookException;
import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.dto.GenreDTO;
import com.prm.group6.model.entity.Book;
import com.prm.group6.model.entity.BookGenre;
import com.prm.group6.model.entity.Genre;
import com.prm.group6.repositories.BookGenreRepository;
import com.prm.group6.repositories.BookRepository;
import com.prm.group6.repositories.GenreRepository;
import com.prm.group6.services.BookService;
import com.prm.group6.services.mappers.BookMapper;
import com.prm.group6.services.mappers.GenreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<BookDTO> getBookList() {
        List<BookDTO> bookDTOList= new ArrayList<>();
        List<Book> bookList = bookRepository.findAll();
        bookList.forEach(book -> {
            BookDTO b = BookMapper.INSTANCE.bookToBookDto(book);
            b = getBookGenre(b);
            bookDTOList.add(b);
        });
        return bookDTOList;
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

    public List<BookDTO> getBookListByBookNameOrAuthor(String str) {
        List<BookDTO> bookDTOList = new ArrayList<>();
        List<Book> bookList = bookRepository.findByTitleContainingOrAuthorContainingIgnoreCase(str, str);
        bookList.forEach(book -> {
            BookDTO b = BookMapper.INSTANCE.bookToBookDto(book);
            b = getBookGenre(b);
            bookDTOList.add(b);
        });
        return bookDTOList;
    }

    public BookDTO getBookById(int bookId) {
        Book book = bookRepository.findByBookId(bookId);
        BookDTO b = BookMapper.INSTANCE.bookToBookDto(book);
        b = getBookGenre(b);
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
            System.out.println(BookException.BOOK_NOT_FOUND);
        }
        return bookDTO;
    }
    public void deleteBook(int id){
        Book book = bookRepository.findByBookId(id);
        if (Objects.nonNull(book)){
            bookRepository.deleteById(String.valueOf(id));
        }else {
            System.out.println(BookException.BOOK_NOT_FOUND);
        }
    }

}
