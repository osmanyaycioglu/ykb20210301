package com.training.micro.models;

import java.util.List;

public class Order {

    private String       customerName;
    private Long         customerId;
    private List<String> meals;
    private Long         amount;

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

    public List<String> getMeals() {
        return this.meals;
    }

    public void setMeals(final List<String> mealsParam) {
        this.meals = mealsParam;
    }

    @Override
    public String toString() {
        return "Order [customerName="
               + this.customerName
               + ", customerId="
               + this.customerId
               + ", meals="
               + this.meals
               + "]";
    }

    public Long getAmount() {
        return this.amount;
    }

    public void setAmount(final Long amountParam) {
        this.amount = amountParam;
    }


}
