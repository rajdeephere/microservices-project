package com.invoice.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Table(name = "INVOICE")
public class Invoice {

  @Id
  @GeneratedValue
  @UuidGenerator
  @Column(name = "INVOICE_ID", nullable = false, length = 255)
  private String invoiceId;

  @Column(name = "USER_ID", nullable = false, length = 255)
  private String userId;

  @Column(name = "INVOICE_NUMBER", nullable = false, length = 255)
  private String invoiceNumber;

  @Column(name = "PRODUCT_IDS", nullable = false, columnDefinition = "TEXT")
  private String productIds;

  @Column(name = "AMOUNT", nullable = false)
  private BigDecimal amount;

  @CreationTimestamp
  @Column(name = "CREATED_AT", nullable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "UPDATED_AT", nullable = false)
  private LocalDateTime updatedAt;

}
