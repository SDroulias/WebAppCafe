package com.webappcafe.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private long id;
    private LocalDateTime date;
    private long customerId;
    private String status;

    private List<String> productsOfOrder;
    private double totalPrice;

    public Order() {
    }

    private Order(long id, LocalDateTime date, long customerId, String status) {
        setId(id);
        setDate(date);
        setCustomerId(customerId);
        setStatus(status);
    }
    
    private Order(long customerId) {
        setCustomerId(customerId);
    }
    
    private Order(long customerId, String status) {
        setCustomerId(customerId);
        setStatus(status);
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

    public List<String> getProductsOfOrder() {
        return productsOfOrder;
    }

    public void setProductsOfOrder(List<String> productsOfOrder) {
        this.productsOfOrder = productsOfOrder;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public static Order createOrder(long id, LocalDateTime date, long customerId, String status) {
        return new Order(id, date, customerId, status);
    }

    public static Order createOrder(long customerId) {
        return new Order(customerId);
    }

    @Override
    public String toString() {
        return "Order{" + 
                "id=" + id + 
                ", date=" + date + 
                ", customerId=" + customerId + 
                ", status=" + status + '}';
    }
}
