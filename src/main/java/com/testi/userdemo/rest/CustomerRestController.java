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

import com.testi.userdemo.Data.Customer;
import com.testi.userdemo.service.CustomerService;

@RestController
public class CustomerRestController {
    CustomerService cs;

    @Autowired
    public CustomerRestController(CustomerService cs){
        this.cs = cs;
    }
    
    @GetMapping("/customers")  //palauttaa kaikki asiakkaat
    public List<Customer> getCustomers(){
        return cs.getCustomers();
    }

    @PostMapping("/customers")  //lisää uuden asiakkaan
    public String addCustomer(@RequestBody Customer customer){
        cs.addCustomer(customer);
        return "Customer added";
    }

    @DeleteMapping("/customers") //poistaa tietyn asiakkaan
    public String removeCustomer(@RequestBody Customer customer){
        cs.removeCustomer(customer.getId());
        return "Customer removed";
    }

    @PutMapping("/customers") //Päivittää tietyn asiakkaan
    public String updateCustomer(@RequestBody Customer customer){
        boolean result = cs.updateCustomer(customer);
        if(result){
            return "Customer updated";
        }
        return "Customer not found";
    }

    @GetMapping("/customers/{id}")  //palauttaa tietyn asiakkaan
    public ResponseEntity<Customer> getCustomer(@PathVariable int id){
        Customer p = cs.findCustomer(id);
        if(p != null){
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
