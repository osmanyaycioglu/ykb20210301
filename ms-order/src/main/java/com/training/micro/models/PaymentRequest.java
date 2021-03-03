package com.training.micro.models;


public class PaymentRequest {

    private String customerName;
    private Long   customerId;
    private Long   amount;

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(final String customerNameParam) {
        this.customerName = customerNameParam;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final Long customerIdParam) {
        this.customerId = customerIdParam;
    }

    public Long getAmount() {
        return this.amount;
    }

    public void setAmount(final Long amountParam) {
        this.amount = amountParam;
    }

    @Override
    public String toString() {
        return "PaymentRequest [customerName="
               + this.customerName
               + ", customerId="
               + this.customerId
               + ", amount="
               + this.amount
               + "]";
    }


}
