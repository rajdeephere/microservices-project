package com.user.service.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.user.service.dto.InvoiceDTO;
import com.user.service.dto.UserInfo;
import com.user.service.entities.UserEntity;
import com.user.service.exception.UserException;
import com.user.service.repos.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepo userRepo;
  private final InvoiceService invoiceService;

  public List<UserInfo> getAllUsers(List<String> userIds) {

    if(CollectionUtils.isEmpty(userIds)) {
      throw new UserException(
           BAD_REQUEST,
          "User Ids cannot be empty",
          "Please provide valid user ids to fetch the user details"
      );
    }

    List<UserEntity> userEntities = userRepo.findAllById(userIds);
    if(CollectionUtils.isEmpty(userEntities)) {
      throw new UserException(
          BAD_REQUEST,
          "No user found for the provided user ids",
          "Please provide valid user ids to fetch the user details"
      );
    }
    return userEntities.stream()
        .map(this::convertToUserInfo)
        .toList();
  }

  private UserInfo convertToUserInfo(UserEntity userEntity) {

    log.info("call to open feign client to fetch invoice details for user id: {}", userEntity.getUserId());
    List<InvoiceDTO> invoiceDTOS=
        invoiceService.callInvoiceServiceAndGetInvoiceDTOList(userEntity.getUserId());

    UserInfo userInfo = new UserInfo();
    userInfo.setUserId(userEntity.getUserId());
    userInfo.setName(userEntity.getName());
    userInfo.setAge(userEntity.getAge());
    userInfo.setGender(userEntity.getGender());
    userInfo.setCreatedTime(userEntity.getCreatedTime());
    userInfo.setUpdatedTime(userEntity.getUpdatedTime());
    userInfo.setInvoiceDTOList(invoiceDTOS);

    return userInfo;
  }
}
