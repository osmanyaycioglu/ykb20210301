package com.training.micro;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {


    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify-sms-q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notify-req-ex",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notify.sms"))
    @SendTo("notify-res-ex/notify.reponse")
    public String handleSMSMessage(final NotifyRequest str) {
        System.out.println("SMS Notify Request : " + str);
        return "SMS sent : " + str;
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify-email-q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notify-req-ex",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notify.email"))
    @SendTo("notify-res-ex/notify.reponse")
    public String handleEmailMessage(final NotifyRequest str) {
        System.out.println("EMAIL Notify Request : " + str);
        return "EMAIL sent : " + str;

    }

}
