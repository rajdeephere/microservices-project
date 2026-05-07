package com.user.service.client;

import java.util.List;

import com.user.service.dto.InvoiceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "invoice-service", url = "${invoice.service.url}", path = "/v1")
public interface InvoiceServiceFeignClient {

  @GetMapping("/invoices")
  List<InvoiceDTO> getInvoices(@RequestParam("user_id") String userId);

}
