package com.tw.mfdb.navdetails.exceptions;

public class NoNavHistoryFoundException extends RuntimeException {
    public NoNavHistoryFoundException(String schemeCode, String date){
        super("No nav history found for given date " + date + " and scheme code " + schemeCode);
    }
}
