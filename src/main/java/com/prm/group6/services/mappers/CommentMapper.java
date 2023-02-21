package com.prm.group6.services.mappers;

import com.prm.group6.model.dto.CommentDTO;
import com.prm.group6.model.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
    CommentDTO commentToCommentDto(Comment comment);
    Comment commentDtoToComment(CommentDTO commentDTO);
}
