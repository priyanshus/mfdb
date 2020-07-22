package com.tw.mfdb.schemedetails.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String entity){
        super("Provided entity " + entity + " does not exist.");
    }
}
