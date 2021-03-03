package com.training.micro.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api1/v1/employee/query")
public class EmployeeQueryController {

    @GetMapping("/get/name")
    public String getName(@RequestParam("name") final String employeeName) {
        return "Returned : " + employeeName;
    }

}
