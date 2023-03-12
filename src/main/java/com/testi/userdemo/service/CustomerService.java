package com.testi.userdemo.service;

import com.testi.userdemo.Data.Customer;
import com.testi.userdemo.Data.Order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private List<Customer> customers = new ArrayList<>();

    public CustomerService(){
        customers.add(new Customer(0, "Jussi", "Mäki", "Espoo jotain", "049494994", "jussi.jotain@jotain.fi", new ArrayList<>(), new ArrayList<>()));
        customers.add(new Customer(1, "Erkki", "Keke", "Espoo jotains", "0494949294", "erkki.jotain@jotain.fi", new ArrayList<>(), new ArrayList<>()));
        customers.add(new Customer(2, "Perkki", "Tete", "Espoo jotainss", "0494943994", "perkki.jotain@jotain.fi", new ArrayList<>(), new ArrayList<>()));
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public List<Customer> getCustomers(){
        return new ArrayList<>(customers); 
    }

    public Customer findCustomer(int id){
        for (Customer customer : customers) {
            if(customer.getId() == id){
                return customer;
            }
        }
        return null;
    }

    public boolean removeCustomer(int id){
        Customer c = findCustomer(id);
            if(c != null){
                return customers.remove(c);
            }
        return false;
    }

    public boolean updateCustomer(Customer customer){  //päivittää asiakkaan perustietoja
        for(Customer c : customers){
            if(c.getId() == customer.getId()){
                c.setFirstName(customer.getFirstName());
                c.setLastName(customer.getLastName());
                c.setStreetAddress(customer.getStreetAddress());
                c.setPhoneNumber(customer.getPhoneNumber());
                c.setEmail(customer.getEmail());
                return true;
            }
        }
        return false;
    }

    public List<Order> getOpenOrders(int id){  //hakee avoimet tilaukset
        Customer c = findCustomer(id);
        return c.getCurrentOrders();
    } 
}
