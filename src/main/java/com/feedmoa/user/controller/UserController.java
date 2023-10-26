package com.feedmoa.user.controller;

import com.feedmoa.user.dto.UserJoinRequest;
import com.feedmoa.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/feedmoa/join")
    public ResponseEntity<?> joinUser(@RequestBody UserJoinRequest request) {

        Long userId = userService.saveUser(request);

        return ResponseEntity.created(URI.create("/feedmoa/" + userId)).build();
    }
}
