package com.infosys.userms.exception;

public class WeCareException extends RuntimeException{
    private String message;
    private int errorCode;

    public WeCareException(String message, int errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
    public WeCareException() {}

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
