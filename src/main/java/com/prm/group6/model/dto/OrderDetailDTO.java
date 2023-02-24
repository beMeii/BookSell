package com.prm.group6.model.dto;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDTO {
    @NotNull
    @Pattern(regexp = "^\\d+(\\.\\d+)?$")
    private float price;
    @NotNull
    @Pattern(regexp = "^[0-9]+$")
    private int quantity ;
    @NotNull
    private BookDTO book;
}
