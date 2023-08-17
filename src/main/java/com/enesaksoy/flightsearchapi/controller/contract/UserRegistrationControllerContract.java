package com.enesaksoy.flightsearchapi.controller.contract;

import com.enesaksoy.flightsearchapi.dto.user.AuthenticationRequest;
import com.enesaksoy.flightsearchapi.dto.user.LoginRequest;
import com.enesaksoy.flightsearchapi.dto.user.UserDTO;

public interface UserRegistrationControllerContract {
    UserDTO createUser(AuthenticationRequest authRequestDto);
    String authenticate(LoginRequest request);
}
