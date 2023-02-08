package com.prm.group6.controllers;

import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.dto.GenreDTO;
import com.prm.group6.services.BookService;
import com.prm.group6.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    GenreService genreService;
    @GetMapping("/retrieve")
    public ResponseEntity<List<BookDTO>> getBookList(){
        return ResponseEntity.ok(bookService.getBookList());
    }
    @GetMapping("/genre")
    public ResponseEntity<List<GenreDTO>> getGenreList(){
        return ResponseEntity.ok(genreService.getGenreList());
    }
    @PostMapping("/listBook/{genreId}")
    public ResponseEntity<List<BookDTO>> getBookListByGenreId(@PathVariable int genreId){
        return ResponseEntity.ok(bookService.getBookListByGenreId(genreId));
    }

}
