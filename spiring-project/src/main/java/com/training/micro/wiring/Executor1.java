package com.training.micro.wiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Qualifier("execQ1")
//@Primary
@Profile("live")
public class Executor1 implements IExecutor {

    @Override
    public String execute(final String strParam) {
        return "Hello live " + strParam;
    }

}
