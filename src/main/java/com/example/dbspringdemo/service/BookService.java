package com.example.dbspringdemo.service;


import com.example.dbspringdemo.entity.Book;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public interface BookService {


  Page<Book> getAllBooksWithPagination(int page, int limit,String sort);

  List<Book> getAllBooks();

  Book getById(int id);

  Book createBookResource(Book book);

  Book updateBookResource(int id, String name);

}
