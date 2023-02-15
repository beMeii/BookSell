package com.prm.group6.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum AccountException {
    WRONG_EMAIL_PASSWORD("","Wrong email or password"),
    EMAIL_IS_DUPLICATE("","Email is already existed");
    private String errorCode;
    private String message;
}
