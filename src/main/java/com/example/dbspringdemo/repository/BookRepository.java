package com.example.dbspringdemo.repository;

import com.example.dbspringdemo.entity.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

  List<Book> findByName(String name);

}
