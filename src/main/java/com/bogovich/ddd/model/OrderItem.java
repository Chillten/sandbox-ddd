package com.bogovich.ddd.model;

import org.springframework.util.Assert;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class OrderItem {

    private String product;
    private Integer amount;
    private BigDecimal value;

    private OrderItem(String product, Integer amount, BigDecimal value) {
        this.product = product;
        this.amount = amount;
        this.value = value;
    }

    public static OrderItem of(String product, Integer amount, BigDecimal value) {
        Assert.notNull(product, "product cant be null");
        Assert.notNull(amount, "amount cant be null");
        Assert.notNull(value, "value cant be null");
        return new OrderItem(product, amount, value);
    }

    public String getProduct() {
        return product;
    }

    public Integer getAmount() {
        return amount;
    }

    public BigDecimal getValue() {
        return value;
    }
}
