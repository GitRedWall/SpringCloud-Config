package com.ilabservice.intelab.controller.unsecure;

import com.ilabservice.intelab.restful.object.RestObject;
import com.ilabservice.intelab.restful.object.RestRoleArray;
import com.ilabservice.intelab.security.auth.JwtAuthenticationToken;
import com.ilabservice.intelab.security.model.UserContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gxu on 2/26/18.
 */
@RestController
public class HealthController {

    /**
     * used for test if restful service is running. Simply return "OK" to client
     * @return
     */
    @RequestMapping(value="/api/unsecure/health", method= RequestMethod.GET)
    public @ResponseBody
    RestObject checkServerHealthy(){
        return new RestObject("OK");
    }
}
