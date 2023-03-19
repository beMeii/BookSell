package com.prm.group6.repositories;

import com.prm.group6.model.entity.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface BookGenreRepository extends JpaRepository<BookGenre,String> {
        List<BookGenre> findByGenreId(int genreId);

        List<BookGenre> findByBookId(int bookId);
        @Query("SELECT MAX(bookGenreId) AS max FROM BookGenre ")
        int getMaxBookGenreId();
        @Transactional
        @Modifying
        void deleteByBookIdAndGenreId(int bookId, int genre);
}
