package a.b.c;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import a.b.d.MyOtherBean;

@Configuration
public class MyOtherConfig {

    @Bean
    public MyOtherBean myOtherBean() {
        return new MyOtherBean();
    }

}
