package com.bogovich.ddd.model;

import javax.persistence.AttributeConverter;

public class OrderNumberAttributeConverter implements AttributeConverter<OrderNumber, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OrderNumber attribute) {
        if (attribute != null) {
            return attribute.toInteger();
        }
        return null;
    }

    @Override
    public OrderNumber convertToEntityAttribute(Integer dbData) {
        if (dbData != null) {
            return OrderNumber.of(dbData);
        }
        return null;
    }
}
