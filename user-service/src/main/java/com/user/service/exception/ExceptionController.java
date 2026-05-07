package com.user.service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(UserException.class)
  public ResponseEntity<UserError> handleUserException(UserException ex) {
    UserError error = new UserError(ex.getErrorMessage(), ex.getErrorDetails());
    error.setErrorMessage(ex.getErrorMessage());
    error.setErrorDetails(ex.getErrorDetails());
    return new ResponseEntity<>(error, ex.getHttpStatus());
  }
}
