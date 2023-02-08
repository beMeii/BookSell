package com.prm.group6.services.mappers;

import com.prm.group6.model.dto.GenreDTO;
import com.prm.group6.model.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper

public interface GenreMapping {
    GenreMapping INSTANCE = Mappers.getMapper(GenreMapping.class);
    GenreDTO genreToGenreDto(Genre genre);
}
