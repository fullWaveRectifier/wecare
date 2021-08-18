package com.infosys.bookingms.exception;

public class WeCareException extends RuntimeException {
    private int errorCode;
    private String message;

    public WeCareException() {
    }

    public WeCareException(String message, int errorCode) {
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
