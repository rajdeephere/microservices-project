package com.user.service.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.user.service.dto.UserInfo;
import com.user.service.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/users")
  public List<UserInfo> getUsers(@RequestParam("ids") List<String> ids) {

    log.info("Received request for ids : {} ", ids);

    return userService.getAllUsers(ids);
  }

}
