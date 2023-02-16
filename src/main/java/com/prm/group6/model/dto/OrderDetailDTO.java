package com.prm.group6.model.dto;
import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder

public class OrderDetailDTO {
    private float price;
    private int quantity ;
    private BookDTO book;

}
