package com.tw.mfdb.authenticate;

import com.tw.mfdb.common.ErrorCodes;
import com.tw.mfdb.common.ErrorResponse;
import com.tw.mfdb.navdetails.exceptions.NoNavHistoryFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AuthenticationControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InvalidOTPException.class)
    public ResponseEntity<ErrorResponse> handleInvalidOtpException(InvalidOTPException e)  {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), ErrorCodes.INVALID_OTP);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
