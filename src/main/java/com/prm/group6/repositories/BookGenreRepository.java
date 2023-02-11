package com.prm.group6.repositories;

import com.prm.group6.model.entity.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface BookGenreRepository extends JpaRepository<BookGenre,String> {
        List<BookGenre> findByGenreId(int genreId);

        List<BookGenre> findByBookId(int bookId);
}
