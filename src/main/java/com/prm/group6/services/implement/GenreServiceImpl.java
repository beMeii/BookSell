package com.prm.group6.services.implement;

import com.prm.group6.model.dto.GenreDTO;
import com.prm.group6.model.entity.Genre;
import com.prm.group6.repositories.GenreRepository;
import com.prm.group6.services.GenreService;
import com.prm.group6.services.mappers.GenreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    GenreRepository genreRepository;
    public List<GenreDTO> getGenreList() {
        List<GenreDTO> genreDTOList = new ArrayList<>();
        List<Genre> genreList = genreRepository.findAll();
        genreList.forEach(genre -> {
            genreDTOList.add(GenreMapper.INSTANCE.genreToGenreDto(genre));
        });
        return genreDTOList;
    }
}
