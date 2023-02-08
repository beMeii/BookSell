package com.prm.group6.repositories;


import com.prm.group6.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,String> {

}
