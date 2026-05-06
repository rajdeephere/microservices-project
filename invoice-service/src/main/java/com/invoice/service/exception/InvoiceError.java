package com.invoice.service.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvoiceError {

  private String errorMessage;
  private List<String> errorDetails;

}
