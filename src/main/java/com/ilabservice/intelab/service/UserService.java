package com.ilabservice.intelab.service;


import com.ilabservice.intelab.model.User;
import com.ilabservice.intelab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public User getByUsername(String username){
        return this.userRepository.findByUserName(username);
    }

}
