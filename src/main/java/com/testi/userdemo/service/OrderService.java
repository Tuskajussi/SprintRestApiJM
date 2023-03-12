package com.testi.userdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.testi.userdemo.Data.Order;

@Service
public class OrderService {
    
    private List<Order> orders = new ArrayList<>();

    public OrderService(){ //wannabe tietokanta
        orders.add(new Order(0, 1, new ArrayList<>(), "Espoon jossakin", false));
        orders.add(new Order(1, 0, new ArrayList<>(), "kekelassa", true));
        orders.add(new Order(2, 2, new ArrayList<>(), "Jormassa", false));
    }

    public void addOrder(Order order){ //lisää tilaus
        orders.add(order);
    }

    public List<Order> getOrders(){ //hakee tilaukset
        return new ArrayList<>(orders); 
    }

    public Order findOrder(int id){  //etsi tilaus id:llä
        for (Order order : orders) {
            if(order.getOrderId() == id){
                return order;
            }
        }
        return null;
    }

    public boolean removeOrder(int id){ //poista tilaus id:llä
        Order o = findOrder(id);
            if(o != null){
                return orders.remove(o);
            }
        return false;
    }

    public boolean updateOrder(Order order){  //päivitä tilauksen perustietoja
        for(Order o : orders){
            if(o.getOrderId() == order.getOrderId()){
                o.setProducts(order.getProducts());
                o.setDeliveryStreetAddress(order.getDeliveryStreetAddress());
                return true;
            }
        }
        return false;
    }
    public boolean orderDelivered(Order order, boolean status){  //päivittää tilauksen toimitustietoa
        for(Order o : orders){
            if(o.getOrderId() == order.getOrderId()){
                o.setDelivered(status);
                return true;
            }
        }
        return false;
    }
}
