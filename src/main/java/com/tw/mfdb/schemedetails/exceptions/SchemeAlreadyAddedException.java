package com.tw.mfdb.schemedetails.exceptions;

public class SchemeAlreadyAddedException extends RuntimeException {

    public SchemeAlreadyAddedException(String entity){
        super("Provided entity " + entity + " already exists.");
    }
}
