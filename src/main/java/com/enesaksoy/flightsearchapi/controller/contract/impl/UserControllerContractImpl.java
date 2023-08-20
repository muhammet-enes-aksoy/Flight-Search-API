package com.enesaksoy.flightsearchapi.controller.contract.impl;

import com.enesaksoy.flightsearchapi.controller.contract.UserControllerContract;
import com.enesaksoy.flightsearchapi.dto.user.UserDTO;
import com.enesaksoy.flightsearchapi.dto.user.UserDeleteRequest;
import com.enesaksoy.flightsearchapi.dto.user.UserRegisterRequest;
import com.enesaksoy.flightsearchapi.entity.User;
import com.enesaksoy.flightsearchapi.mapper.UserMapper;
import com.enesaksoy.flightsearchapi.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContract {

    private final UserEntityService userEntityService;
    @Override
    public List<UserDTO> findAll() {
        List<User> userList = userEntityService.getAllUsers();
        return UserMapper.INSTANCE.convertToUserDTOList(userList);
    }

    @Override
    public UserDTO findById(Long id) {

            User user = userEntityService.getUserById(id);
            return UserMapper.INSTANCE.convertToUserDTO(user);
    }

    @Override
    public void delete(UserDeleteRequest userDeleteRequest) {
            userEntityService.deleteUser(userDeleteRequest.getId());
    }

    @Override
    public UserDTO save(UserRegisterRequest userRegisterRequest) {
        User user = UserMapper.INSTANCE.convertToUser(userRegisterRequest);
        user = userEntityService.save(user);
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }

}
