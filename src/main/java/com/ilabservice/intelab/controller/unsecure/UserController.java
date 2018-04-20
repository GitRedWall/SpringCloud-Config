package com.ilabservice.intelab.controller.unsecure;

import com.ilabservice.intelab.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * This controller handles APIs about User without logging in:
 * /find/password
 */
@RestController("unsecureUserController")
@RequestMapping(value = "/api/unsecure")
public class UserController {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    // to be implemented


}
