package com.tw.mfdb.signup;

import com.tw.mfdb.common.ErrorCodes;
import com.tw.mfdb.common.ErrorResponse;
import com.tw.mfdb.schemedetails.exceptions.EntityNotFoundException;
import com.tw.mfdb.signup.exceptions.UserAlreadySignedUpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SignupControlledAdvice {

    @ExceptionHandler(UserAlreadySignedUpException.class)
    public ResponseEntity<ErrorResponse> handleAlreadySignedUpUser(UserAlreadySignedUpException exception)  {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), ErrorCodes.EXISTING_USER);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
