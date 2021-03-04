package com.training.micro.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PaymentRequest {

    @NotEmpty
    @Size(min = 2, max = 25)
    private String customerName;
    @NotNull
    @Positive
    private Long   customerId;
    @NotNull
    @Positive
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
