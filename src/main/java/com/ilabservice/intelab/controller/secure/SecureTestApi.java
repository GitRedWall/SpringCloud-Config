package com.ilabservice.intelab.controller.secure;


import com.ilabservice.intelab.security.auth.JwtAuthenticationToken;
import com.ilabservice.intelab.security.model.UserContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureTestApi {
    @RequestMapping(value="/api/secure/me", method= RequestMethod.GET)
    public @ResponseBody
    UserContext get(JwtAuthenticationToken token){
        return (UserContext) token.getPrincipal();
    }
}
