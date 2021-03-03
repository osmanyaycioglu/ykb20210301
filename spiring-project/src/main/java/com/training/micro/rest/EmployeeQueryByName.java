package com.training.micro.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2/v1/employee/query/by/name")
public class EmployeeQueryByName {

    @GetMapping
    public String getName(@RequestParam("name") final String employeeName) {
        return "Returned : " + employeeName;
    }
}
