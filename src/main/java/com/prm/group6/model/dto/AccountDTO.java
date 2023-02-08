package com.prm.group6.model.dto;

import lombok.Builder;

@Builder

public class AccountDTO {
    private String accountId;
    private String email;
    private String password;
    private int roleId;
}
