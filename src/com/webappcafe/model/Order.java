package com.webappcafe.model;

import java.time.LocalDateTime;

public class Order {

    private long id;
    private LocalDateTime date;
    private long customerId;
    private String status;

    public Order() {
    }

    private Order(long id, LocalDateTime date, long customerId, String status) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
        this.status = status;
    }

    private Order(long customerId, String status) {
        this.customerId = customerId;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Order createOrder(long id, LocalDateTime date, long customerId, String status) {
        return new Order(id, date, customerId, status);
    }

    public static Order createOrder(long customerId, String status) {
        return new Order(customerId, status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", customerId=" + customerId +
                ", status='" + status + '\'' +
                '}';
    }
}
