package com.enesaksoy.flightsearchapi.mapper;

import com.enesaksoy.flightsearchapi.dto.user.UserDTO;
import com.enesaksoy.flightsearchapi.dto.user.UserRegisterRequest;
import com.enesaksoy.flightsearchapi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO convertToUserDTO(User user);
    User convertToUser(UserRegisterRequest userRegisterRequest);
    List<UserDTO> convertToUserDTOList(List<User> userList);
}