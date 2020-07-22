package com.tw.mfdb.signup.exceptions;

public class UserAlreadySignedUpException extends RuntimeException {
    public UserAlreadySignedUpException(String entity){
        super("Provided entity " + entity + " already exist.");
    }
}
