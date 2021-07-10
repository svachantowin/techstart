package com.techstart.rediscache.controller;

import com.techstart.rediscache.domain.User;
import com.techstart.rediscache.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Cacheable(value="users", key = "#userId", unless = "#result.followers < 1000")
    @GetMapping("/{userId}")
    public User getUser(@PathVariable ("userId") Long userId){
        logger.info("Get User API invoked");
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User does not exist"));
    }

}
