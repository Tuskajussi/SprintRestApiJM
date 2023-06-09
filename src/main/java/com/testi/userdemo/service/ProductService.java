package com.testi.userdemo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.testi.userdemo.Data.Product;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public ProductService(){
        products.add(new Product(0, "ps2", 300));
        products.add(new Product(1, "joku", 450));
        products.add(new Product(4, "Coca-Cola Light", 100));
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public List<Product> getProducts(){
        return new ArrayList<>(products); 
    }

    public Product findProduct(int id){
        for (Product product : products) {
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }

    public boolean removeProduct(int id){
        Product p = findProduct(id);
            if(p != null){
                return products.remove(p);
            }
        return false;
    }

    public boolean updateProduct(Product product){
        for(Product p : products){
            if(p.getId() == product.getId()){
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                return true;
            }
        }
        return false;
    }
}
