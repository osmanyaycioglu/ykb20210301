package com.training.micro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Service
public class MyLoadBalancer {

    @Autowired
    private EurekaClient ec;

    public void balanceRequest(final String ms) {
        Application applicationLoc = this.ec.getApplication(ms);
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {

        }

    }

    @Scheduled(fixedDelay = 10_000)
    public void name() {
        System.out.println("Schedule Çalıştı");
    }


}
