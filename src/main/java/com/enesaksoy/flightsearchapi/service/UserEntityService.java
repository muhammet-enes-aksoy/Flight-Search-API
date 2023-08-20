package com.enesaksoy.flightsearchapi.service;

import com.enesaksoy.flightsearchapi.entity.User;
import com.enesaksoy.flightsearchapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityService{

    private final UserRepository userRepository;

    public UserEntityService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers(){return userRepository.findAll();}
    public User getUserById(Long id){return userRepository.findById(id).orElseThrow();}
    public User save(User user) {
        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        userRepository.delete(userRepository.findById(id).orElseThrow());
    }

}