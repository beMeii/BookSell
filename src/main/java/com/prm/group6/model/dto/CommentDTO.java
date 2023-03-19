package com.prm.group6.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime timestamp;
    @NonNull
    private int bookId;
    @NonNull
    private int customerId;
    private String name;
}
