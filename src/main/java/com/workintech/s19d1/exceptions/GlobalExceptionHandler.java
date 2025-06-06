package com.workintech.s19d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handLeException(ApiException apiException){

        log.error("apiexception occured:" + apiException);
     return new ResponseEntity<>(new ExceptionResponse(apiException.getMessage(),
             apiException.getHttpStatus().value(),
             LocalDateTime.now()),
             apiException.getHttpStatus());
    }




    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handLeException(Exception exception) {
        log.error("excention occured: " + exception);
        return new ResponseEntity<>(new ExceptionResponse(exception.getMessage(),
                HttpStatus. INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
