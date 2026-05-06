package com.invoice.service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(InvoiceException.class)
  public ResponseEntity<InvoiceError> handleInvoiceException(InvoiceException ex) {
    InvoiceError error = new InvoiceError(ex.getErrorMessage(), ex.getErrorDetails());
    error.setErrorMessage(ex.getErrorMessage());
    error.setErrorDetails(ex.getErrorDetails());
    return new ResponseEntity<>(error, ex.getHttpStatus());
  }

}
