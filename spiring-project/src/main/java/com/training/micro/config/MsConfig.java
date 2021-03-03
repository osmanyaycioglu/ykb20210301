package com.training.micro.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ms")
public class MsConfig {

    private String subDomain;
    private String boundedContext;
    private String microService;

    public String getSubDomain() {
        return this.subDomain;
    }

    public void setSubDomain(final String subDomainParam) {
        this.subDomain = subDomainParam;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public void setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
    }

    public String getMicroService() {
        return this.microService;
    }

    public void setMicroService(final String microServiceParam) {
        this.microService = microServiceParam;
    }


}
