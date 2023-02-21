package com.prm.group6.model;

public enum ErrorEnum {
    BOOK_NOT_FOUND("EC002", "Book not found"),
    BOOK_IS_DUPLICATE("","Book is already existed");;

    private String errorCode;
    private String errorMessage;

    ErrorEnum(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
