package com.enesaksoy.flightsearchapi.controller.contract;

import com.enesaksoy.flightsearchapi.dto.user.UserDTO;
import com.enesaksoy.flightsearchapi.dto.user.UserDeleteRequest;
import com.enesaksoy.flightsearchapi.dto.user.UserRegisterRequest;
import com.enesaksoy.flightsearchapi.dto.user.UserUpdateRequest;

import java.util.List;

public interface UserControllerContract {
    List<UserDTO> findAll();
    UserDTO findById(Long id);
    UserDTO findByUsername(String username);
    void delete(UserDeleteRequest userDeleteRequest);
    UserDTO update(Long id, UserUpdateRequest userUpdateRequest);
    UserDTO save (UserRegisterRequest userRegisterRequest);

}
