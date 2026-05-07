package com.user.service.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.user.service.client.InvoiceServiceFeignClient;
import com.user.service.dto.InvoiceDTO;
import com.user.service.exception.InvoiceException;
import com.user.service.exception.UserException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class InvoiceService {

  private final InvoiceServiceFeignClient invoiceServiceFeignClient;

  public List<InvoiceDTO> callInvoiceServiceAndGetInvoiceDTOList(String userId) {

    List<InvoiceDTO> invoiceResponse;

    try {

      invoiceResponse = invoiceServiceFeignClient.getInvoices(userId);

    } catch (InvoiceException invoiceException) {
      throw invoiceException;
    } catch (FeignException.ServiceUnavailable ex) {
      throw new UserException(HttpStatus.SERVICE_UNAVAILABLE,"Downstream service unavailable", "invoice-service is down");
    } catch (Exception ex) {
      throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR,"Downstream service unavailable", "invoice-service is down");
    }

    return invoiceResponse;
  }


}
