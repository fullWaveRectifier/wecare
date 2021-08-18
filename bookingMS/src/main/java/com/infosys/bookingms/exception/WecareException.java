package com.infosys.bookingms.exception;

public class WecareException extends RuntimeException {
    private int errorCode;
    private String message;

    public WecareException() {
    }

    public WecareException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
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
