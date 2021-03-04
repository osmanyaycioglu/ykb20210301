package com.training.micro.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.models.Order;
import com.training.micro.services.PaymentService;

@RestController
@RequestMapping("/api/v1/restaurant/order")
public class OrderController {

    @Autowired
    private PaymentService ps;

    @PostMapping("/place")
    public String placeOrder(final Order orderParam) {
        return this.ps.placeOrder(orderParam);
    }

    @PostMapping("/place2")
    public String placeOrder2(final Order orderParam) {
        return this.ps.placeOrder2(orderParam);
    }

}
