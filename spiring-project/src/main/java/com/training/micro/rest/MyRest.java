package com.training.micro.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/map")
public class MyRest {

    @GetMapping("/hello1/{xyz}/{abc}")
    public String hello(@PathVariable("xyz") final String name,
                        @PathVariable("abc") final String surname) {
        return "Hello " + name + " " + surname;
    }

}
