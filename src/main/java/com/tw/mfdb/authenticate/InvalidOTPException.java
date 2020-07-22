package com.tw.mfdb.authenticate;

public class InvalidOTPException extends RuntimeException {
    public InvalidOTPException(){
        super("Not a valid OTP");
    }
}
