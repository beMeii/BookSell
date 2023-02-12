package com.prm.group6.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum BookException {
    BOOK_NOT_FOUND("","Book is not existed"),
    BOOK_IS_DUPLICATE("","Book is already existed");
    private String errorCode;
    private String message;

}
