package com.training.micro.wiring;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "excutor")
public class ExecutorProp {

    private String       type;
    private String       test;
    private List<String> list;

    public String getType() {
        return this.type;
    }

    public void setType(final String typeParam) {
        this.type = typeParam;
    }

    public String getTest() {
        return this.test;
    }

    public void setTest(final String testParam) {
        this.test = testParam;
    }

    public List<String> getList() {
        return this.list;
    }

    public void setList(final List<String> listParam) {
        this.list = listParam;
    }


}
