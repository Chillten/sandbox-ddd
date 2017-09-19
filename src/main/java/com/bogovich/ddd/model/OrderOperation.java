package com.bogovich.ddd.model;

import java.math.BigDecimal;
import java.util.function.Function;

public enum OrderOperation implements Function<OrderItem, OrderItem>{
    DISCOUNT {
        @Override
        public OrderItem apply(OrderItem item) {
            return OrderItem.of(item.getProduct(),
                    item.getAmount(),
                    item.getValue().multiply(new BigDecimal("0.8")));
        }
    },
    SHIPPING_COST {
        @Override
        public OrderItem apply(OrderItem item) {
            return OrderItem.of(item.getProduct(),
                    item.getAmount(),
                    item.getValue().multiply(new BigDecimal("1.2")));
        }
    }

}
