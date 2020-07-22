package com.tw.mfdb.schemedetails;

import com.tw.mfdb.schemedetails.exceptions.EntityNotFoundException;
import com.tw.mfdb.common.ErrorCodes;
import com.tw.mfdb.common.ErrorResponse;
import com.tw.mfdb.schemedetails.exceptions.SchemeAlreadyAddedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SchemeControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElement(EntityNotFoundException entityNotFound)  {
        ErrorResponse errorResponse = new ErrorResponse(entityNotFound.getMessage(), ErrorCodes.ENTITY_NOT_FOUND);

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SchemeAlreadyAddedException.class)
    public ResponseEntity<ErrorResponse> handleSchemeAlreadyAdded(SchemeAlreadyAddedException alreadyAdded)  {
        ErrorResponse errorResponse = new ErrorResponse(alreadyAdded.getMessage(), ErrorCodes.EXISTING_SCHEME);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
