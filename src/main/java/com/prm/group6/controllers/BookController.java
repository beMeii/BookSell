package com.prm.group6.controllers;

import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.dto.CommentDTO;
import com.prm.group6.model.dto.GenreDTO;
import com.prm.group6.model.entity.Book;
import com.prm.group6.services.BookService;
import com.prm.group6.services.CommentService;
import com.prm.group6.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    GenreService genreService;
    @Autowired
    CommentService commentService;
    @GetMapping("/retrieve")
    public ResponseEntity<List<BookDTO>> getBookList(){
        return ResponseEntity.ok(bookService.getBookList());
    }
    @GetMapping("/genre")
    public ResponseEntity<List<GenreDTO>> getGenreList(){
        return ResponseEntity.ok(genreService.getGenreList());
    }
    @GetMapping("/listBook/{genreId}")
    public ResponseEntity<List<BookDTO>> getBookListByGenreId(@PathVariable int genreId){
        return ResponseEntity.ok(bookService.getBookListByGenreId(genreId));
    }
    @GetMapping("/search")
    public ResponseEntity<List<BookDTO>> getBookListByBookNameOrAuthor(@RequestParam("query") String query){
        return new ResponseEntity<>(bookService.getBookListByBookNameOrAuthor(query), HttpStatus.OK);
    }
    @GetMapping("/view/{bookId}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("bookId") int bookId){
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }
    @PostMapping("/add")
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO){
        return new ResponseEntity<>(bookService.addNewBook(bookDTO), HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO bookDTO){
        return new ResponseEntity<>(bookService.updateBook(bookDTO),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{bookId}")
    public void deleteEmployee(@PathVariable int bookId){
        bookService.deleteBook(bookId);
    }

    // comment
    @PostMapping("/addComment")
    public ResponseEntity<BookDTO> addComment(@RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(bookService.addComment(commentDTO),HttpStatus.OK);
    }
}
