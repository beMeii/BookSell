package com.prm.group6.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BookException extends RuntimeException {
    public BookException(String errorMessage){
        super(errorMessage);
    }
}
