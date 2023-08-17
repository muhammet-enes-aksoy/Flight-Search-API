package com.enesaksoy.flightsearchapi.service;

import com.enesaksoy.flightsearchapi.dto.user.UserDTO;
import com.enesaksoy.flightsearchapi.dto.user.UserDeleteRequest;
import com.enesaksoy.flightsearchapi.dto.user.UserUpdateRequest;
import com.enesaksoy.flightsearchapi.entity.User;
import com.enesaksoy.flightsearchapi.mapper.UserMapper;
import com.enesaksoy.flightsearchapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityService{

    private final UserRepository userRepository;

    public UserEntityService(UserRepository repository, UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username){return userRepository.findByUsername(username).orElseThrow();}
    public List<User> getAllUsers(){return userRepository.findAll();}
    public User getUserById(Long id){return userRepository.findById(id).orElseThrow();}
    public User save(User user) {
        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        userRepository.delete(userRepository.findById(id).orElseThrow());
    }
    public UserDTO updateUser(Long id, UserUpdateRequest userUpdateRequest){
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(userUpdateRequest.getUsername());
        userRepository.save(user);
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }


}