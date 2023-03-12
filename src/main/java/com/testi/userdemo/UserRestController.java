package com.testi.userdemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    private UserService uService = new UserService();

    @PostMapping("/")
    public String getBasicInfo(
        @RequestParam String lang
    ){
        return "jsee" + lang;
    }
    @PostMapping("/user")  //add user
    public String addUser(@RequestBody User user){
        uService.add(user);
        return user.getName() + " " + user.getAge() + " added";
    }

    @GetMapping("/users/{keyword}") //get Users
    public List<User> getUsers(@PathVariable String keyword){
       // return new User[]{
         //   new User("reima", 3),
           // new User("lissa", 12)
        //};
        return uService.searchUser(keyword);
    }

    @PostMapping("/users")
    public String addUserMap(@RequestBody Map<String,String> json){
        return json.get("name") + json.get("age");
    }

    @GetMapping("/")
    public String getHomeWithParam(
            @RequestParam String lang,
            @RequestParam Integer id
        ){
        if(lang.equals("eng")){
            return "This is ture" + id;
        }
        return "falseapas" + id;
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Integer id){
        if(id == 10){
            return "jee 10";
        }
        return "jee ei";
    }
    @GetMapping("/user/{category}/{id}")
    public String getUser(@PathVariable String category, @PathVariable Integer id){
        if(id == 10){
            return "jee 10";
        }
        return "jee ei";
    }
    @GetMapping("/custom")
    public Map<String,String> getCustom(){
        Map<String,String> json = new HashMap<>();
        json.put("width", "45");
        json.put("height", "123");

        return json;
    }

   @GetMapping("/student")
    public ResponseEntity<String> getStudent(){//Tässä vois olla vaikka <User, Integer, String yms
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String,String> json = new HashMap<>();
        json.put("message", "Returning user");
        return new ResponseEntity(json, headers, HttpStatus.OK); //HttpStatus.UNAUTHORIZED yms voi antaa vastaukseks
    }

}
