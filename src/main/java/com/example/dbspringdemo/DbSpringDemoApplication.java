package com.example.dbspringdemo;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.persistence.PostPersist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbSpringDemoApplication {

  @PersistenceContext(type = PersistenceContextType.EXTENDED)
  private EntityManager entityManager;


  UserRepository userRepository;

  public static void main(String[] args) {
    SpringApplication.run(DbSpringDemoApplication.class, args);
  }


/*  @PostConstruct
  public void start(){
    User u = new User();
    u.setName("test rach");
    EntityTransaction t = entityManager.getTransaction();
    t.begin();
    userRepository.save(u);
    t.commit();
  }*/

}
