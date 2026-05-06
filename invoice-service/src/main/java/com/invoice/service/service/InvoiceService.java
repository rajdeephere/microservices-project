package com.invoice.service.service;

import java.util.List;

import lombok.RequiredArgsConstructor;

import com.invoice.service.dto.InvoiceDto;
import com.invoice.service.entities.Invoice;
import com.invoice.service.repos.InvoiceRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceService {

  private final InvoiceRepository invoiceRepository;

  public List<InvoiceDto> getInvoicesByUserId(String userId) {
    List<Invoice> invoices = invoiceRepository.findByUserId(userId);

    return invoices.stream()
        .map(this::mapToDto)
        .toList();

  }

  private InvoiceDto mapToDto(Invoice invoice) {

    InvoiceDto invoiceDto = new InvoiceDto();
    invoiceDto.setInvoiceId(invoice.getInvoiceId());
    invoiceDto.setInvoiceNumber(invoice.getInvoiceNumber());
    invoiceDto.setProductIds(invoice.getProductIds());
    invoiceDto.setUpdatedAt(invoice.getUpdatedAt().toString());

    return invoiceDto;
  }
}
