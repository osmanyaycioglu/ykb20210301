package com.training.micro.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/map")
public class MyRest {

    @GetMapping("/hello1/{xyz}/{abc}")
    public String hello1(@PathVariable("xyz") final String name,
                         @PathVariable("abc") final String surname) {
        return "Hello1 " + name + " " + surname;
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam("xyz") final String name,
                         @RequestParam("abc") final String surname) {
        return "Hello2 " + name + " " + surname;
    }

    @GetMapping("/hello3/{xyz}")
    public String hello3(@PathVariable("xyz") final String name,
                         @RequestParam("abc") final String surname) {
        return "Hello3 " + name + " " + surname;
    }

    @GetMapping("/hello4")
    public String hello4(@RequestHeader("isim") final String name,
                         @RequestHeader("soyisim") final String surname) {
        return "Hello4 " + name + " " + surname;
    }


}
