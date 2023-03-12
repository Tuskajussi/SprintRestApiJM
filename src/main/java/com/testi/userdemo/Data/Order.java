package com.testi.userdemo.Data;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private int customerId;
    private List<Product> products = new ArrayList<>();
    private String deliveryStreetAddress;

    public Order() {
    }

    public Order(int orderId, int customerId, List<Product> products, String deliveryStreetAddress) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.products = products;
        this.deliveryStreetAddress = deliveryStreetAddress;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }
    public void removeProduct(Product product){
        this.products.remove(product.getId());
    }

    public String getDeliveryStreetAddress() {
        return this.deliveryStreetAddress;
    }

    public void setDeliveryStreetAddress(String deliveryStreetAddress) {
        this.deliveryStreetAddress = deliveryStreetAddress;
    }
}
