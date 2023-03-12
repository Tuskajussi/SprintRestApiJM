package com.testi.userdemo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testi.userdemo.service.ProductService;


import com.testi.userdemo.Data.Product;

@RestController
//@RequestMapping("/product")
public class ProductRestController {
    ProductService pc;

    @Autowired
    public ProductRestController(ProductService pc){
        this.pc = pc;
    }
    
    @GetMapping("/products")  //palauttaa kaikki tuotteet
    public List<Product> getProducts(){
        return pc.getProducts();
    }

    @PostMapping("/products")  //lisää uuden tuotteen
    public String addProduct(@RequestBody Product product){
        pc.addProduct(product);
        return "Product added";
    }

    @DeleteMapping("/products") //poistaa tietyn tuotteen
    public String removeProduct(@RequestBody Product product){
        pc.removeProduct(product.getId());
        return "Product removed";
    }

    @PutMapping("/products") //Päivittää tietyn tuotteen
    public String updateProduct(@RequestBody Product product){
        boolean result = pc.updateProduct(product);
        if(result){
            return "Product updated";
        }
        return "Product not found";
    }

    @GetMapping("/products/{id}")  //palauttaa tietyn tuotteen
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        Product p = pc.findProduct(id);
        if(p != null){
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
