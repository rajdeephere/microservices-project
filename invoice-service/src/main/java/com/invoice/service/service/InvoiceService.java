package com.invoice.service.service;

import java.util.List;

import lombok.RequiredArgsConstructor;

import com.invoice.service.entities.Invoice;
import com.invoice.service.repos.InvoiceRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceService {

  private final InvoiceRepository invoiceRepository;

  public List<Invoice> getInvoicesByUserId(String userId) {
    List<Invoice> invoices = invoiceRepository.findByUserId(userId);

    return invoices;

  }
}
