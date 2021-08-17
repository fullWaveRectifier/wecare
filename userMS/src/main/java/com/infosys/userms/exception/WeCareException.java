package com.infosys.userms.exception;

public class WeCareException extends RuntimeException{
    public String message;
    public WeCareException(String message) {
        super(message);
        this.message = message;
    }
    public WeCareException() {}
}
