package com.enesaksoy.flightsearchapi.controller.contract;

import com.enesaksoy.flightsearchapi.dto.user.UserDTO;
import com.enesaksoy.flightsearchapi.dto.user.UserDeleteRequest;
import com.enesaksoy.flightsearchapi.dto.user.UserRegisterRequest;

import java.util.List;

public interface UserControllerContract {
    List<UserDTO> findAll();
    UserDTO findById(Long id);
    void delete(UserDeleteRequest userDeleteRequest);
    UserDTO save (UserRegisterRequest userRegisterRequest);

}
