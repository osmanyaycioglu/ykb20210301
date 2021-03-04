package com.training.micro.rest.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObject {

    private List<ErrorObject> subErrors;
    private String            subDomain;
    private String            boundedContext;
    private String            microservice;
    private String            desc;
    private Integer           cause;


    public ErrorObject() {
    }

    public ErrorObject(final String subDomainParam,
                       final String boundedContextParam,
                       final String microserviceParam,
                       final String descParam,
                       final Integer causeParam) {
        super();
        this.subDomain = subDomainParam;
        this.boundedContext = boundedContextParam;
        this.microservice = microserviceParam;
        this.desc = descParam;
        this.cause = causeParam;
    }

    public List<ErrorObject> getSubErrors() {
        return this.subErrors;
    }

    public ErrorObject setSubErrors(final List<ErrorObject> subErrorsParam) {
        this.subErrors = subErrorsParam;
        return this;
    }

    public ErrorObject addSubErrorObject(final ErrorObject errorObjectParam) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(errorObjectParam);
        return this;
    }

    public String getSubDomain() {
        return this.subDomain;
    }

    public ErrorObject setSubDomain(final String subDomainParam) {
        this.subDomain = subDomainParam;
        return this;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public ErrorObject setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
        return this;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public ErrorObject setMicroservice(final String microserviceParam) {
        this.microservice = microserviceParam;
        return this;
    }

    public String getDesc() {
        return this.desc;
    }

    public ErrorObject setDesc(final String descParam) {
        this.desc = descParam;
        return this;
    }

    public Integer getCause() {
        return this.cause;
    }

    public ErrorObject setCause(final Integer causeParam) {
        this.cause = causeParam;
        return this;
    }

    public static void main(final String[] args) {
        ErrorObject errorObjectLoc = new ErrorObject("sub1",
                                                     "CRM",
                                                     "ms",
                                                     "error oluştu",
                                                     1000);
        ErrorObject errorObjectLoc2 = new ErrorObject().setSubDomain("sub1")
                                                       .setBoundedContext("CRM")
                                                       .setMicroservice("ms")
                                                       .setDesc("error oluştu")
                                                       .setCause(1000);
    }


}
