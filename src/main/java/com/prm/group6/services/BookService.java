package com.prm.group6.services;

import com.prm.group6.model.dto.BookDTO;

import java.util.List;
public interface BookService {
    List<BookDTO> getBookList();
    List<BookDTO> getBookListByGenreId(int genreId);
    List<BookDTO> getBookListByBookNameOrAuthor(String str);
}
