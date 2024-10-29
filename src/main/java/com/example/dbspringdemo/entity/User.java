package com.example.dbspringdemo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class User {

  @Id
  private int id;

  private String name;

  @ManyToMany
  @JoinTable(name = "user_library",
  joinColumns = @JoinColumn(name = "user_id"),
  inverseJoinColumns = @JoinColumn(name = "library_id"))
  private List<Library> libraryList;

}
