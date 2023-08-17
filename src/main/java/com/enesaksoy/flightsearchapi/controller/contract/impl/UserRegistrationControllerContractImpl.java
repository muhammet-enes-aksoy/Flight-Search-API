package com.enesaksoy.flightsearchapi.controller.contract.impl;

import com.enesaksoy.flightsearchapi.config.JwtService;
import com.enesaksoy.flightsearchapi.controller.contract.UserRegistrationControllerContract;
import com.enesaksoy.flightsearchapi.dto.user.AuthenticationRequest;
import com.enesaksoy.flightsearchapi.dto.user.LoginRequest;
import com.enesaksoy.flightsearchapi.dto.user.UserDTO;
import com.enesaksoy.flightsearchapi.entity.User;
import com.enesaksoy.flightsearchapi.mapper.UserMapper;
import com.enesaksoy.flightsearchapi.repository.UserRepository;
import com.enesaksoy.flightsearchapi.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserRegistrationControllerContractImpl implements UserRegistrationControllerContract {

    private final UserRegistrationService userRegistrationService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    @Override
    public UserDTO createUser(AuthenticationRequest authRequestDto) {

        User user = userRegistrationService.registerAppUser(authRequestDto);
        return UserMapper.INSTANCE.convertToUserDTO(user);

    }

    @Override
    public String authenticate(LoginRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        return jwtService.generateToken(user);

    }

}
