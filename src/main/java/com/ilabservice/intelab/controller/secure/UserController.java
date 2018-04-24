package com.ilabservice.intelab.controller.secure;

import com.ilabservice.intelab.repository.UserRepository;
import com.ilabservice.intelab.restful.object.RestObject;
import com.ilabservice.intelab.restful.object.RestRoleArray;
import com.ilabservice.intelab.restful.object.RestUser;
import com.ilabservice.intelab.security.auth.JwtAuthenticationToken;
import com.ilabservice.intelab.security.model.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gxu on 1/29/18.
 */
@RestController("secureUserController")
@RequestMapping(value="/api/secure/customer/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="", method = RequestMethod.GET)
    public @ResponseBody
    RestObject GetUser(JwtAuthenticationToken token){
        UserContext context = (UserContext) token.getPrincipal();
        return new RestObject(new RestUser(userRepository.findByUserName(context.getUsername())));
    }

    @RequestMapping(value="/roles", method = RequestMethod.GET)
    public @ResponseBody
    RestObject GetUserRoles(JwtAuthenticationToken token){
        UserContext context = (UserContext)token.getPrincipal();
        return new RestObject(new RestRoleArray(userRepository.findByUserName(context.getUsername()).getRoles()));
    }

}
