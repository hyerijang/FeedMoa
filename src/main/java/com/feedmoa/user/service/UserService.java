package com.feedmoa.user.service;

import com.feedmoa.user.dto.UserJoinRequest;
import com.feedmoa.user.entity.User;
import com.feedmoa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long saveUser(UserJoinRequest request) {

        User user = User.builder()
                .account(request.getAccount())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        User savedUser = userRepository.save(user);

        return savedUser.getId();
    }
}
