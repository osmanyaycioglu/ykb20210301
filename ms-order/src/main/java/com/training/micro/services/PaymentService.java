package com.training.micro.services;

import java.security.SecureRandom;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.micro.clients.IAccountingClient;
import com.training.micro.clients.error.RestClientException;
import com.training.micro.models.NotifyRequest;
import com.training.micro.models.Order;
import com.training.micro.models.PaymentRequest;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate      rt;

    @Autowired
    private IAccountingClient iac;

    @Autowired
    private RabbitTemplate    rabt;

    public String placeOrder(final Order order) {
        PaymentRequest paymentRequestLoc = new PaymentRequest();
        paymentRequestLoc.setCustomerId(order.getCustomerId());
        paymentRequestLoc.setCustomerName(order.getCustomerName());
        paymentRequestLoc.setAmount(100L);
        return this.rt.postForObject("http://ACCOUNTING/api/v1/accounting/payment/pay",
                                     paymentRequestLoc,
                                     String.class);
    }

    public String placeOrder2(final Order order) throws RestClientException {
        PaymentRequest paymentRequestLoc = new PaymentRequest();
        paymentRequestLoc.setCustomerId(order.getCustomerId());
        paymentRequestLoc.setCustomerName(order.getCustomerName());
        paymentRequestLoc.setAmount(order.getAmount());

        NotifyRequest notifyRequestLoc = new NotifyRequest();
        SecureRandom randomLoc = new SecureRandom();
        notifyRequestLoc.setDest("" + randomLoc.nextInt());
        notifyRequestLoc.setMessage("Message " + randomLoc.nextInt());
        this.rabt.convertAndSend("notify-req-ex",
                                 "notify.email",
                                 notifyRequestLoc);

        notifyRequestLoc = new NotifyRequest();
        notifyRequestLoc.setDest("" + randomLoc.nextInt());
        notifyRequestLoc.setMessage("Message " + randomLoc.nextInt());
        this.rabt.convertAndSend("notify-req-ex",
                                 "notify.sms",
                                 notifyRequestLoc);
        return this.iac.pay(paymentRequestLoc);
    }

}
