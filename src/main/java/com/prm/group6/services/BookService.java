package com.prm.group6.services;

import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.dto.CommentDTO;

import java.util.List;
public interface BookService {
    List<BookDTO> getBookList();
    List<BookDTO> getBookListByGenreId(int genreId);
    List<BookDTO> getBookListByBookNameOrAuthor(String str);
    BookDTO getBookById(int bookId);
    BookDTO addNewBook(BookDTO bookDTO);
    BookDTO updateBook(BookDTO bookDTO);
    void deleteBook(int bookId);
    BookDTO addComment(CommentDTO commentDTO);
}
