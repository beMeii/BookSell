package com.prm.group6.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDTO {
    private String address;
    @Pattern(regexp = "@Pattern(regexp = \"^[0-9]+$\")")
    private String phone;

}
