package com.prm.group6.repositories;

import com.prm.group6.model.entity.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookGenreRepository extends JpaRepository<BookGenre,String> {
//    @Query(value = "SELECT B FROM Book B " +
//            "JOIN BookGenre BG ON B.bookId = BG.bookId" +
//            "WHERE BG.genreId =?1")
//    List<Object[]> findByGenreId(int genreId);
//@Query(value = "SELECT BB FROM Book BB, BookGenre BG WHERE B.bookId = BG.bookId" +
//        "WHERE BG.genreId =?1")
//List<Object[]> findByGenreId(int genreId);
}
