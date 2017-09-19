package com.bogovich.ddd.model;

import com.google.common.collect.ForwardingList;
import com.google.common.collect.ImmutableList;
import org.springframework.util.Assert;

import java.util.List;

public class OrderItems extends ForwardingList<OrderItem> {

    private final List<OrderItem> value;

    private OrderItems(List<OrderItem> value) {
        this.value = value;
    }

    public static OrderItems of(List<OrderItem> value) {
        Assert.notNull(value, "Cant be null!");
        return new OrderItems(ImmutableList.copyOf(value));
    }

    @Override
    protected List<OrderItem> delegate() {
        return value;
    }

    public Integer getSize() {
        return this.value.size();
    }
}
