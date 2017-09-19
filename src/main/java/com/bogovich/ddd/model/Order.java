package com.bogovich.ddd.model;

import org.springframework.util.Assert;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private OrderNumber number;

    @ElementCollection
    private List<OrderItem> items = new ArrayList<>();
    private List<OrderItem> discountItems = new ArrayList<>();

    Order() {}

    public static Order of(OrderNumber number) {
        Assert.notNull(number, "OrderNumber can't be null!");
        return new Order(number);
    }

    public OrderNumber getNumber() {
        return number;
    }

    private Order(OrderNumber number) {
        this.number = number;
    }

    public void apply(OrderOperation orderOperation) {
        items.stream().map(orderOperation).collect(Collectors.toList());
    }

    public Order addItem(OrderItem item) {
        Assert.notNull(item, "item is null");
        this.items.add(item);
        return this;
    }

    public OrderItems getItems() {
        return OrderItems.of(items);
    }

    public OrderItems getDiscountItems() {
        return OrderItems.of(discountItems);
    }
}
