package com.ilabservice.intelab.controller.secure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller handles the APIs about company object for authorized client
 * /company
 */
@RestController("secureCompanyController")
@RequestMapping(value = "/api/secure")
public class CompanyController {
    private static Logger logger = LoggerFactory.getLogger(CompanyController.class);

}
