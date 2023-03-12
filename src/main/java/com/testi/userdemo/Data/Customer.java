package com.testi.userdemo.Data;

import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String phoneNumber;
    private String email;

    private int id;
    private List<Order> oldOrders;
    private List<Order> currentOrders;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String streetAddress, String phoneNumber, String email, int id, List<Order> oldOrders, List<Order> currentOrders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id = id;
        this.oldOrders = oldOrders;
        this.currentOrders = currentOrders;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Order> getOldOrders() {
        return this.oldOrders;
    }

    public void addOldOrder(Order order) {
        this.oldOrders.add(order);
    }

    public List<Order> getCurrentOrders() {
        return this.currentOrders;
    }

    public void addCurrentOrder(Order order) {
        this.currentOrders.add(order);
    }
}
