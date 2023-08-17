package com.enesaksoy.flightsearchapi.controller;

import com.enesaksoy.flightsearchapi.RestResponse;
import com.enesaksoy.flightsearchapi.controller.contract.UserRegistrationControllerContract;
import com.enesaksoy.flightsearchapi.dto.user.AuthenticationRequest;
import com.enesaksoy.flightsearchapi.dto.user.LoginRequest;
import com.enesaksoy.flightsearchapi.dto.user.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserRegistrationControllerContract userRegistrationControllerContract;

    @PostMapping("/register")
    public ResponseEntity<RestResponse<UserDTO>> createUser(@RequestBody AuthenticationRequest authRequestDto) {

        UserDTO userDTO = userRegistrationControllerContract.createUser(authRequestDto);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<RestResponse<String>> authenticate(@RequestBody LoginRequest request) {
        String jwtToken = userRegistrationControllerContract.authenticate(request);
        return ResponseEntity.ok(RestResponse.of(jwtToken));
    }
}
