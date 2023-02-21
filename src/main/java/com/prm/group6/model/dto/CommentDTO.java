package com.prm.group6.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommentDTO {
    private String commentId;
    private String content;
    private int rating;
    private LocalDateTime timestamp;
    @NonNull
    private int bookId;
    @NonNull
    private int customerId;
}
