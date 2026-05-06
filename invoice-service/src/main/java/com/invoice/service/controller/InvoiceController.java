package com.invoice.service.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;

import com.invoice.service.entities.Invoice;
import com.invoice.service.service.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/invoices")
public class InvoiceController {

  private final InvoiceService invoiceService;

  @GetMapping
  public List<Invoice> getInvoicesByUserId(@RequestParam("user_id")  String userId) {
    return invoiceService.getInvoicesByUserId(userId);

  }
}
