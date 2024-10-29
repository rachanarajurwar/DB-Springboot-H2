package com.example.dbspringdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Library {

  @Id
  private int id;

  private String name;

  @OneToMany(mappedBy = "library")
  private List<Book> book;

  @ManyToMany(mappedBy = "libraryList")
  private List<User> userList;

  @OneToOne
  @JoinColumn(name = "address_id")
  private Address address;

}
