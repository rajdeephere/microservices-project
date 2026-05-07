package com.user.service.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class UserInfo {

  private String userId;
  private String name;
  private int age;
  private String gender;
  private LocalDateTime createdTime;
  private LocalDateTime updatedTime;
  private List<InvoiceDTO> invoiceDTOList;
}
