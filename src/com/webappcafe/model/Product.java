package com.webappcafe.model;

public class Product {

    private long id;
    private String name;
    private String description;
    private double price;
    private byte isAvailable;

    public Product() {
    }

    /*
     *  This constructor is when Admin wants to create a Product.
     *  No id is required because it is updated by the database.
     *  Availability is true by default.
     */
    private Product(String name, String description, double price) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setIsAvailable((byte)1); //setting available when a Product is created
    }

    /*
     *  This constructor is for fetching a Product from database
     */
    private Product(long id, String name, String description, double price, byte isAvailable) {
        setId(id);
        setName(name);
        setDescription(description);
        setPrice(price);
        setIsAvailable(isAvailable);
    }

    public byte getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(byte isAvailable) {
        this.isAvailable = isAvailable;
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

    public static Product createProduct(long id, String name, String description, double price, byte isAvailable) {
        return new Product(id, name, description, price, isAvailable);
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
