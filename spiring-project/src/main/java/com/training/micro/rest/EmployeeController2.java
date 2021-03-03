package com.training.micro.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.models.Employee;

@RestController
@RequestMapping("/api2/v1/employee/provision")
public class EmployeeController2 {

    @PutMapping
    public String add(@RequestBody final Employee employee) {
        String xLoc = "Received : " + employee;
        System.out.println(xLoc);
        return xLoc;
    }

    @PostMapping
    public String change(@RequestBody final Employee employee) {
        String xLoc = "Received : " + employee;
        System.out.println(xLoc);
        return xLoc;
    }

    @DeleteMapping
    public String suspend(@RequestParam("eid") final Long employeeId) {
        return "Deleted : " + employeeId;
    }


}
