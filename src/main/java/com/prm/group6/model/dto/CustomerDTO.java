package com.prm.group6.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Timestamp birthday;
    private String gender;
    private String name;
}
