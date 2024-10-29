package com.example.dbspringdemo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.Instant;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Book")
public class Book {

  @Id
  @GeneratedValue
  private int id;

  private String name;

  @Enumerated(EnumType.STRING)
  private GENERA genera;

  @Temporal(TemporalType.DATE)
  private Date createdAt;

  @PrePersist
  private void addCurrentDate(){
    this.createdAt = Date.from(Instant.now());
  }

  public Book(String name, GENERA genera){
    this.name = name;
    this.genera = genera;
  }

}
