package com.example.dbspringdemo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="user-detail")
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  @GeneratedValue
  private int id;

  private String name;

  @Temporal(TemporalType.DATE)
  private Date createdAt;

  @PrePersist
  public void addDate(){
    this.createdAt = new Date();
  }

  User(String name){
    this.name = name;
  }

}
