package com.prm.group6.model.dto;

import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ListResponse {
    private int totalPage;
    private List<BookDTO> listBook;
}
