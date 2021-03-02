package com.training.micro.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/rest")
public class MyFirstRest {

    @GetMapping
    public String helloRest() {
        return "hello rest";
    }


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/hello")
    public String helloPost() {
        return "hello Post";
    }

    @PutMapping("/hello")
    public String helloPut() {
        return "hello Put";
    }

    @DeleteMapping("/hello")
    public String helloDelete() {
        return "hello Delete";
    }

    @PatchMapping("/hello")
    public String helloPatch() {
        return "hello Patch";
    }

}
