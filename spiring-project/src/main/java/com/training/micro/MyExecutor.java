package com.training.micro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.training.micro.wiring.IExecutor;

@Component
//@Scope("prototype")
public class MyExecutor {

    @Autowired
    @Qualifier("execMethod")
    private IExecutor executor;

    private String    value;

    public void exec() {
        System.out.println(this.executor.execute(this.value));
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(final String valueParam) {
        this.value = valueParam;
    }

}
