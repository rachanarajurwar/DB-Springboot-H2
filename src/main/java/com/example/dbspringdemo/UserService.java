package com.example.dbspringdemo;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {


  @Autowired
  private UserRepository userRepository;

  @PostConstruct
  public void initDB() {
    //new Random().nextInt(100)
    List<User> users = IntStream.range(1, 200)
        .mapToObj(i -> new User("User" + i))
        .collect(Collectors.toList());
    userRepository.saveAll(users);
  }

}
