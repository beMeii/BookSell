package com.prm.group6.services.mappers;

import com.prm.group6.model.dto.GenreDTO;
import com.prm.group6.model.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);
    GenreDTO genreToGenreDto(Genre genre);
}
