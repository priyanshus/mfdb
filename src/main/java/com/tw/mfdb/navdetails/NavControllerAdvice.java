package com.tw.mfdb.navdetails;

import com.tw.mfdb.common.ErrorCodes;
import com.tw.mfdb.common.ErrorResponse;
import com.tw.mfdb.navdetails.exceptions.NoNavHistoryFoundException;
import com.tw.mfdb.schemedetails.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class NavControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NoNavHistoryFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoNavHistoryFoundException(NoNavHistoryFoundException e)  {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), ErrorCodes.ENTITY_NOT_FOUND);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
