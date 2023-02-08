package com.prm.group6.services.mappers;

import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper

public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    BookDTO bookToBookDto(Book book);
}
