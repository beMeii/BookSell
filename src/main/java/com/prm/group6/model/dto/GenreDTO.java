package com.prm.group6.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GenreDTO {
    private int genreId;
    private String genreName;
}
