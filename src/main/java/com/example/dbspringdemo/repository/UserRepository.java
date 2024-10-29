package com.example.dbspringdemo.repository;

import com.example.dbspringdemo.entity.Address;
import com.example.dbspringdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
