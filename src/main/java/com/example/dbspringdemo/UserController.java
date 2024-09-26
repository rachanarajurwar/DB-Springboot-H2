package com.example.dbspringdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserRepository userRepository;

  @GetMapping("/user")
  public String getTry(){
    return "Hello there !!!!";
  }

  @PostMapping("/user")
  public void createUser(){
    User u = new User();
    u.setId(7);
    u.setName("test rach");
    userRepository.save(u);
  }

}
