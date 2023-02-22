package com.prm.group6.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommentDTO {
    private int commentId;
    private String content;
    private double rating;
    private LocalDateTime timestamp;
    @NonNull
    private int bookId;
    @NonNull
    private int customerId;
}
