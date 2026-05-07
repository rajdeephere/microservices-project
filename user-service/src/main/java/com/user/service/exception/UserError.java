package com.user.service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserError {

  private String errorMessage;
  private String errorDetails;
}
