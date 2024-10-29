package com.example.dbspringdemo.repository;

import com.example.dbspringdemo.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library,Integer> {

  Library findByName(String name);

}
