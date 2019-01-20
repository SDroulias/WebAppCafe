package com.webappcafe.model;


public class Customer {
    private long id;
    private String fname;
    private String lname;
    private String username;
    private String password;

    public Customer() {
    }


    public Customer(long id, String fname, String lname, String username, String password) {
        setId(id);
        setFname(fname);
        setLname(lname);
        setUsername(username);
        setPassword(password);
    }
    
    private Customer(String fname, String lname, String username, String password) {
        setFname(fname);
        setLname(lname);
        setUsername(username);
        setPassword(password);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static Customer createCustomer(long id, String fname, String lname, String username, String password) {
        return new Customer(id, fname, lname, username, password);
    }
    
    public static Customer createCustomer(String fname, String lname, String username, String password) {
        return new Customer(fname, lname, username, password);
    }

    @Override
    public String toString() {
        return "Customer{" + 
                "id=" + id + 
                ", fname=" + fname + 
                ", lname=" + lname + 
                ", username=" + username + 
                ", password=" + password + '}';
    }
}