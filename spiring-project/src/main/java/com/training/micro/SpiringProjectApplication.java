package com.training.micro;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.micro.wiring.IExecutor;

import a.b.d.MyOtherBean;

@SpringBootApplication

//@SpringBootApplication(scanBasePackages = {
//                                            "com.training.micro",
//                                            "a.b.c"
//})
//@Controller
//@Service
//@Repository
//@Configuration

public class SpiringProjectApplication implements ApplicationRunner {

    @Autowired
    private MyExecutor       myExecutor1;

    @Autowired
    private MyExecutor       myExecutor2;

    @Autowired
    private MyExecutor       myExecutor3;

    @Autowired
    private MyExecutor       myExecutor4;

    private final MyExecutor myExecutor5;

    private MyExecutor       myExecutor6;

    @Autowired
    @Qualifier("execQ1")
    private IExecutor        execQ1;

    @Autowired
    private MyOtherBean      mob;

    public SpiringProjectApplication(final MyExecutor myExecutorParam) {
        this.myExecutor5 = myExecutorParam;
    }

    @Autowired
    public void xyz(final MyExecutor myExecutorParam) {
        this.myExecutor6 = myExecutorParam;
    }

    @PostConstruct
    public void init() {
        this.myExecutor1.exec();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    public void run(final ApplicationArguments argsParam) throws Exception {
        this.mob.test();
        this.myExecutor1.setValue("osman");
        this.myExecutor2.setValue("ali");
        this.myExecutor3.setValue("veli");
        this.myExecutor4.exec();
        this.execQ1.execute("test");
    }


}
