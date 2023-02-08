package com.prm.group6.services.implement;

import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.entity.Book;
import com.prm.group6.model.entity.BookGenre;
import com.prm.group6.model.entity.Genre;
import com.prm.group6.repositories.BookGenreRepository;
import com.prm.group6.repositories.BookRepository;
import com.prm.group6.repositories.GenreRepository;
import com.prm.group6.services.BookService;
import com.prm.group6.services.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            Genre genre = genreRepository.findByGenreId(bookGenre.getGenreId());
            b.setGenreName(genre.getGenreName());
            bookDTOList.add(b);
        });
        return bookDTOList;
    }
}
