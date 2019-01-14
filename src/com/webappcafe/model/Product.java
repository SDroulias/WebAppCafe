package com.webappcafe.model;

public class Product {

    private long id;
    private String name;
    private String description;
    private double price;

    public Product() {
    }

    private Product(String name, String description, double price) {
        setName(name);
        setDescription(description);
        setPrice(price);
    }

    private Product(long id, String name, String description, double price) {
        setId(id);
        setName(name);
        setDescription(description);
        setPrice(price);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static Product createProduct(long id, String name, String description, double price) {
        return new Product(id, name, description, price);
    }

    public static Product createProduct(String name, String description, double price) {
        return new Product(name, description, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
