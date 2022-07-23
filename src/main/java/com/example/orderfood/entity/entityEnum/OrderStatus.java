package com.example.orderfood.entity.entityEnum;

public enum OrderStatus {
    SALE(0),
    UNSALE(1),
    STOP(2);

    private int value;
    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static OrderStatus of(int value) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if(orderStatus.getValue() == value) {
                return orderStatus;
            }
        }
        return OrderStatus.SALE;
    }
}
