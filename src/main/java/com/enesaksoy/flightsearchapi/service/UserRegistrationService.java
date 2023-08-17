package com.enesaksoy.flightsearchapi.service;

import com.enesaksoy.flightsearchapi.dto.user.AuthenticationRequest;
import com.enesaksoy.flightsearchapi.entity.Airport;
import com.enesaksoy.flightsearchapi.entity.User;
import com.enesaksoy.flightsearchapi.enums.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private final UserEntityService userEntityService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRegistrationService(UserEntityService userEntityService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userEntityService = userEntityService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User registerAppUser(AuthenticationRequest authRequestDto){
        User user = createValidUser(authRequestDto);
        user.setRole(Role.ROLE_USER);
        return this.userEntityService.save(user);
    }

    public User registerAdminUser(AuthenticationRequest authRequestDto){
        User user = createValidUser(authRequestDto);
        user.setRole(Role.ROLE_ADMIN);
        return this.userEntityService.save(user);
    }

    public User createValidUser(AuthenticationRequest authRequestDto) {
        User user = new User();
        user.setUsername(authRequestDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(authRequestDto.getPassword()));
        return user;
    }
}
