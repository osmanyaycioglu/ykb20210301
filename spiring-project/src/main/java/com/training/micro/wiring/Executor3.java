package com.training.micro.wiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("abcv")
public class Executor3 implements IExecutor {

    @Override
    public String execute(final String strParam) {
        return "Ola " + strParam;
    }

}
