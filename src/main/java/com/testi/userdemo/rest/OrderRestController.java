package com.testi.userdemo.rest;

import java.util.List;

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

import com.testi.userdemo.Data.Order;
import com.testi.userdemo.service.OrderService;

@RestController
public class OrderRestController {
    OrderService oc;

    @Autowired
    public OrderRestController(OrderService oc){
        this.oc = oc;
    }
    
    @GetMapping("/orders")  //palauttaa kaikki tilaukset
    public List<Order> getOrders(){
        return oc.getOrders();
    }

    @PostMapping("/orders")  //lisää uuden tilauksen
    public String addOrder(@RequestBody Order order){
        oc.addOrder(order);
        return "Order added";
    }

    @DeleteMapping("/orders") //poistaa tietyn tilauksen
    public String removeOrder(@RequestBody Order order){
        oc.removeOrder(order.getOrderId());
        return "Order removed";
    }

    @PutMapping("/orders") //Päivittää tietyn tilauksen
    public String updateOrder(@RequestBody Order order){
        boolean result = oc.updateOrder(order);
        if(result){
            return "Order updated";
        }
        return "Order not found";
    }

    @GetMapping("/orders/{id}")  //palauttaa tietyn tilauksen
    public ResponseEntity<Order> getOrder(@PathVariable int id){
        Order p = oc.findOrder(id);
        if(p != null){
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
