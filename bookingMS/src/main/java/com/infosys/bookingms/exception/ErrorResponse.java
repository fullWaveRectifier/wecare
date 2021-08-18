package com.infosys.bookingms.exception;

public class ErrorResponse {
    private int errorCode;
    private String message;

    public ErrorResponse(String message, int errorCode) {
        this.message = message;
        this.errorCode=errorCode;
    }

    public ErrorResponse() {
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
