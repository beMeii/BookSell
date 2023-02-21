package com.prm.group6.controllers;

import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.services.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favourite")
public class FavouriteController {
    @Autowired
    FavouriteService favouriteService;
    @GetMapping("/retrieve")
    public ResponseEntity<List<BookDTO>> getFavouriteList(@RequestHeader(name="Authorization") String token){
        return ResponseEntity.ok(favouriteService.getFavouriteList(token));
    }
    @PostMapping("/{id}")
    public ResponseEntity<List<BookDTO>> addFavouriteBook(@RequestHeader(name="Authorization") String token,@PathVariable("id") int bookId){
        return ResponseEntity.ok(favouriteService.addFavourite(token,bookId));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<BookDTO>> removeFavourite(@RequestHeader(name="Authorization") String token,@PathVariable("id") int bookId) {
        return ResponseEntity.ok(favouriteService.removeFavourite(token, bookId));
    }
}
