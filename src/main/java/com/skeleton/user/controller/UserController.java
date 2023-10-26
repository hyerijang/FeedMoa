package com.skeleton.user.controller;

import com.skeleton.user.dto.UserSignupRequest;
import com.skeleton.user.dto.UserSignupResponse;
import com.skeleton.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/feedmoa/join")
    public ResponseEntity<?> joinUser(@Valid @RequestBody UserSignupRequest request) {

        UserSignupResponse verifyCode = userService.saveUser(request);

        return new ResponseEntity<>(verifyCode, HttpStatus.CREATED);
    }
}
