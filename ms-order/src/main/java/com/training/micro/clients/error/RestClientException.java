package com.training.micro.clients.error;

import com.training.micro.rest.error.ErrorObject;

public class RestClientException extends Exception {

    private static final long serialVersionUID = 356581165269481174L;

    private ErrorObject       errorObject;


    public RestClientException() {
    }

    public RestClientException(final ErrorObject errorObjectParam) {
        super();
        this.setErrorObject(errorObjectParam);
    }

    public ErrorObject getErrorObject() {
        return errorObject;
    }

    public void setErrorObject(ErrorObject errorObjectParam) {
        errorObject = errorObjectParam;
    }


}
