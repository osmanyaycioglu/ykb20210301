package com.training.micro.wiring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import a.b.c.MyOtherConfig;

@Configuration
@Import(MyOtherConfig.class)
@PropertySource("classpath:my.properties")
public class ExecutorConfig {

    @Autowired
    private Environment  env;

    @Value("${excutor.type}")
    private Integer      execTypeOld;

    @Value("#{executorProp.getType()}")
    private Integer      execType;

    @Value("'${excutor.test}'.split(',')")
    private List<String> strList;

    @Autowired
    private ExecutorProp ep;

    @Bean
    @Qualifier("execMethod")
    public IExecutor executorCreation2() {
        switch (this.execType) {
            case 1:
                return new Executor1();
            case 2:
                return new Executor2();
            case 3:
                return new Executor3();
            default:
                return new Executor1();
        }
    }

    @Bean
    @Qualifier("exampleMethod")
    public IExecutor executorCreation() {
        String propertyLoc = this.env.getProperty("excutor.type");
        int parseIntLoc = Integer.parseInt(propertyLoc);
        switch (parseIntLoc) {
            case 1:
                return new Executor1();
            case 2:
                return new Executor2();
            case 3:
                return new Executor3();
            default:
                return new Executor1();
        }
    }


}
