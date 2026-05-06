package com.invoice.service.repos;

import java.util.List;

import com.invoice.service.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {

  List<Invoice> findByUserId(String userId);

}
