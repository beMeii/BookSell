package com.prm.group6.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerUpdateStatusRequest {
    @NonNull
    private int customerId;
    @NonNull
    private String status;
}
