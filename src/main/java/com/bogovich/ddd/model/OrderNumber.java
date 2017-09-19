package com.bogovich.ddd.model;

import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Objects;

public class OrderNumber implements Serializable, Formattable {

    private final int value;

    private OrderNumber(int value) {
        this.value = value;
    }

    public static OrderNumber of(int value) {
        Assert.isTrue(value > 0, "Value must be higher 0");
        return new OrderNumber(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderNumber that = (OrderNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "OrderNumber{" +
                "value=" + value +
                '}';
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%d", value);
    }

    public Integer toInteger() {
        return value;
    }
}
