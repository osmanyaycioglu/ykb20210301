package com.training.micro.health;

import java.time.LocalDate;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import com.training.micro.models.EGender;
import com.training.micro.models.Employee;

@Component
public class MyHealth implements HealthIndicator {

    @Override
    public Health health() {
        Employee employeeLoc = new Employee();
        employeeLoc.setName("osman");
        employeeLoc.setSurname("yay");
        employeeLoc.setGender(EGender.MALE);
        employeeLoc.setBirthday(LocalDate.now());
        employeeLoc.setWeight(2000);
        return Health.status(Status.UP)
                     .withDetail("desc",
                                 employeeLoc)
                     .build();
    }

}
