package com.training.micro.rest.error;


public enum EError {

    INTERNAL_ERROR("Internal error oluştu", 1000) {

        @Override
        public String process() {
            return " cause : " + this.cause + " " + this.error;
        }
    },
    VALIDATION_ERROR("Request error oluştu", 1002),
    REQUEST_ERROR("Request error oluştu", 1001);

    final String error;
    final int    cause;

    EError(final String errorParam,
           final int causeParam) {
        this.error = errorParam;
        // TODO Auto-generated constructor stub
        this.cause = causeParam;
    }

    public String getError() {
        return this.error;
    }

    public int getCause() {
        return this.cause;
    }

    public String process() {
        return this.error + " cause : " + this.cause;
    }

    public static void main(final String[] args) {
        System.out.println(EError.REQUEST_ERROR.process());
    }

}
