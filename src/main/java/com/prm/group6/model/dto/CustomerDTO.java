package com.prm.group6.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {
    @JsonIgnore
    private int customerId;
    @NotNull
    private Timestamp birthday;
    @NotNull
    @Pattern(regexp = "^(MALE|FEMALE|OTHER)$")
    private String gender;
    @NotNull
    private String name;
    private String address;
    @Pattern(regexp = "^[0-9]+$")
    private String phone;
}
