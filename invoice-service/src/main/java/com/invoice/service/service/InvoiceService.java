package com.invoice.service.service;

import java.util.List;

import lombok.RequiredArgsConstructor;

import com.invoice.service.dto.InvoiceDto;
import com.invoice.service.entities.Invoice;
import com.invoice.service.exception.InvoiceException;
import com.invoice.service.repos.InvoiceRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
public class InvoiceService {

  private final InvoiceRepository invoiceRepository;

  public List<InvoiceDto> getInvoicesByUserId(String userId) {

    if(StringUtils.isEmpty(userId)) {
      throw new InvoiceException(
          BAD_REQUEST,
          "User ID is required",
          List.of("Please provide a valid user ID")
      );
    }

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
