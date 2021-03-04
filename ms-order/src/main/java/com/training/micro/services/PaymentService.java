package com.training.micro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.micro.clients.IAccountingClient;
import com.training.micro.models.Order;
import com.training.micro.models.PaymentRequest;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate      rt;

    @Autowired
    private IAccountingClient iac;

    public String placeOrder(final Order order) {
        PaymentRequest paymentRequestLoc = new PaymentRequest();
        paymentRequestLoc.setCustomerId(order.getCustomerId());
        paymentRequestLoc.setCustomerName(order.getCustomerName());
        paymentRequestLoc.setAmount(100L);
        return this.rt.postForObject("http://ACCOUNTING/api/v1/accounting/payment/pay",
                                     paymentRequestLoc,
                                     String.class);
    }

    public String placeOrder2(final Order order) {
        PaymentRequest paymentRequestLoc = new PaymentRequest();
        paymentRequestLoc.setCustomerId(order.getCustomerId());
        paymentRequestLoc.setCustomerName(order.getCustomerName());
        paymentRequestLoc.setAmount(100L);
        return this.iac.pay(paymentRequestLoc);
    }

}
