package com.testi.userdemo;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    public void add(User user){
        users.add(user);
    }
    public List<User> searchUser(String keyword){
        //etsi users listasta nimen perusteella henkilöitä ja sit palauttaa ne
        return users;
    }
    public List<User> getUsers(){
        return users;
    }
}
