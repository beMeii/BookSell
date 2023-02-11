package com.prm.group6.model.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookDTO {
    private int bookId;
    private String author;
    private String description;
    private String imageLink;
    private float price;
    private String publisher;
    private String quantityLeft;
    private String status;
    private String title;
    private List<String> genreName;

}
