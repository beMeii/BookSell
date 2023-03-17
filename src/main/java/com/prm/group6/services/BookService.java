package com.prm.group6.services;

import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.dto.CommentDTO;
import com.prm.group6.model.dto.ListResponse;

import java.util.List;
public interface BookService {
    ListResponse getBookList(int pageNo, int pageSize, String sort, String sortType);
    List<BookDTO> getBookListByGenreId(int genreId);
    ListResponse getBookListByBookNameOrAuthor(String str, int pageNo, int pageSize, String sort, String sortType);
    BookDTO getBookById(int bookId);
    BookDTO addNewBook(BookDTO bookDTO);
    BookDTO updateBook(BookDTO bookDTO);
    void deleteBook(int bookId);
    BookDTO addComment(CommentDTO commentDTO);
}
