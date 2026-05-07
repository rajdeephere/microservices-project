package com.user.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Table(name = "USER_RECORD")
public class UserEntity {

  @Id
  @GeneratedValue
  @UuidGenerator
  @Column(name = "USER_ID", nullable = false, length = 200)
  private String userId;

  @Column(name = "NAME", nullable = false, length = 200)
  private String name;

  @Column(name = "AGE", nullable = false)
  private Integer age;

  @Column(name = "GENDER", length = 1)
  private String gender;

  @CreationTimestamp
  @Column(name = "CREATED_TIME", nullable = false)
  private LocalDateTime createdTime;

  @UpdateTimestamp
  @Column(name = "UPDATED_TIME", nullable = false)
  private LocalDateTime updatedTime;

}
