package com.contact.exception;

import com.contact.dto.ResponseWrapper;
import com.contact.enums.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExcpetionHandler {

    @ExceptionHandler(ContactException.class)
    public ResponseEntity<ResponseWrapper> handleContactException(ContactException exception) {
        ResponseWrapper responseWrapper = new ResponseWrapper(Status.FAIL, exception.getMessage());
        return new ResponseEntity<>(responseWrapper, HttpStatus.NOT_FOUND);
    }
}
