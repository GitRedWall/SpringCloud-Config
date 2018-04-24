package com.ilabservice.intelab.controller.unsecure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller handles APIs querying about company object without logging in:
 * /company
 */
@RestController("unsecureCompanyController")
@RequestMapping(value = "/api/unsecure")
public class CompanyController {

}
