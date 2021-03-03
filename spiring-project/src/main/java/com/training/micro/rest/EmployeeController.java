package com.training.micro.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.models.Employee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api1/v1/employee/provision")
public class EmployeeController {

    @PostMapping("/add")
    public String add(@RequestBody final Employee employee) {
        String xLoc = "Received : " + employee;
        System.out.println(xLoc);
        return xLoc;
    }

    @Operation(summary = "Change employee data.", description = "xyz", method = "change")
    @ApiResponses({
                    @ApiResponse(responseCode = "200", description = "success"),
                    @ApiResponse(responseCode = "404", description = "bulunamadı")
    })

    @PostMapping("/change")
    public String change(@RequestBody final Employee employee) {
        String xLoc = "Received : " + employee;
        System.out.println(xLoc);
        return xLoc;
    }

    @GetMapping("/suspend")
    public String suspend(@RequestParam("eid") final Long employeeId) {
        return "Deleted : " + employeeId;
    }

    @GetMapping("/get/name")
    public String getName(@RequestParam("name") final String employeeName) {
        return "Returned : " + employeeName;
    }

}
