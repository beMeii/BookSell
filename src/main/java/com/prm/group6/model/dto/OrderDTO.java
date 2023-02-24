package com.prm.group6.model.dto;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@Builder
public class OrderDTO {
    private int orderId;
    @NotNull
    private String address;
    @NotNull
    @Pattern(regexp = "^[0-9]+$")
    private String phone ;
    @NotNull
    private String status ;
    @NotNull
    private Timestamp time;
    @NotNull
    @Pattern(regexp = "^\\d+(\\.\\d+)?$")
    private float total_amount ;
}
