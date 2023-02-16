package com.prm.group6.model.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderDTO {
    private String address;
    private String phone ;
    private String status ;
    private Timestamp time;
    private float total_amount ;
}
