package com.training.micro.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.clients.error.RestClientException;
import com.training.micro.models.Order;
import com.training.micro.services.PaymentService;

@RestController
@RequestMapping("/api/v1/restaurant/order")
@RefreshScope
public class OrderController {

    @Autowired
    private PaymentService ps;

    @Value("${refresh.test}")
    private String         testStr;

    @GetMapping("/test")
    public String refTest() {
        return this.testStr;
    }

    @PostMapping("/place")
    public String placeOrder(@RequestBody final Order orderParam) {
        return this.ps.placeOrder(orderParam);
    }

    @PostMapping("/place2")
    public String placeOrder2(@RequestBody final Order orderParam) throws RestClientException {
        return this.ps.placeOrder2(orderParam);
    }

}
