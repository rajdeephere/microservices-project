package com.user.service.exception;

import lombok.Data;

import org.springframework.http.HttpStatus;

@Data
public class UserException extends RuntimeException{

  private HttpStatus httpStatus;
  private String errorMessage;
  private String errorDetails;

  public UserException(HttpStatus httpStatus, String errorMessage, String errorDetails) {
    super(errorMessage);
    this.httpStatus = httpStatus;
    this.errorMessage = errorMessage;
    this.errorDetails = errorDetails;
  }
}
