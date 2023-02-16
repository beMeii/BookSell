package com.prm.group6.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private String email;
    private String password;
    private Timestamp birthday;
    private String gender;
    private String name;
}
