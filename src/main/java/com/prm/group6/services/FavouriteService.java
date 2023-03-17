package com.prm.group6.services;
import com.prm.group6.model.dto.BookDTO;

import java.util.List;

public interface FavouriteService {
    List<BookDTO> getFavouriteList(String token,int pageNo, int pageSize) ;

    List<BookDTO> addFavourite(String token, int bookId);

    List<BookDTO> removeFavourite(String token, int bookId);
}
