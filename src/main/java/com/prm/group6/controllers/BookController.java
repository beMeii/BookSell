package com.prm.group6.controllers;

import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.dto.CommentDTO;
import com.prm.group6.model.dto.GenreDTO;
import com.prm.group6.model.dto.ListResponse;
import com.prm.group6.model.entity.Account;
import com.prm.group6.services.BookService;
import com.prm.group6.services.GenreService;
import com.prm.group6.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Autowired
    JwtService jwtService;
    @GetMapping("/retrieve")
    public ResponseEntity<ListResponse> getBookList(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                                    @RequestParam(value = "sort", defaultValue = "title",required = false) String sort,
                                                    @RequestParam(value = "sortType", defaultValue = "ASC",required = false) String sortType){
        return ResponseEntity.ok(bookService.getBookList(pageNo, pageSize, sort, sortType));
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
    public ResponseEntity<ListResponse> getBookListByBookNameOrAuthor(@RequestParam("query") String query,
                                                                      @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                                                      @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                                                      @RequestParam(value = "sort", defaultValue = "title",required = false) String sort,
                                                                      @RequestParam(value = "sortType", defaultValue = "ASC",required = false) String sortType){
        return new ResponseEntity<>(bookService.getBookListByBookNameOrAuthor(query,pageNo, pageSize,sort, sortType), HttpStatus.OK);
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
    public ResponseEntity<BookDTO> addComment(@RequestHeader(name="Authorization") String token,
                                              @RequestBody CommentDTO commentDTO){
        Account acc = jwtService.getAccount(token);
        commentDTO.setCustomerId(acc.getAccountId());
        return new ResponseEntity<>(bookService.addComment(commentDTO),HttpStatus.OK);
    }
}
