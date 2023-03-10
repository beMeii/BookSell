package com.prm.group6.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    @NotNull
    private BookDTO bookDTO;
    @Pattern(regexp = "^[0-9]+$")
    @NotNull
    private int quantity;
}
