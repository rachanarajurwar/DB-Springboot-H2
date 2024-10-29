package com.example.dbspringdemo.controller;


import com.example.dbspringdemo.dto.APIResponse;
import com.example.dbspringdemo.entity.Book;
import com.example.dbspringdemo.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping("/all")
  public APIResponse<List<Book>> getAllBooks(){
    List<Book> books=bookService.getAllBooks();
    return new APIResponse<>(books.size(),books);
  }

  @GetMapping("/{id}")
  public APIResponse<Book> getById(@PathVariable int id){
    Book book=bookService.getById(id);
    return new APIResponse<>(book);
  }

  @GetMapping
  public APIResponse<Page<Book>> getAllBooks(@RequestParam(value = "page",defaultValue = "0") int page,
      @RequestParam(value ="limit",defaultValue = "20") int limit,
      @RequestParam(value = "sort", required = false) String sort){
    Page<Book> books=bookService.getAllBooksWithPagination(page,limit, sort);
   return new APIResponse<>(books.getSize(),books);
  }


  @PostMapping
  public APIResponse<Book> createBookResource(@RequestBody Book request){
   Book book = bookService.createBookResource(request);
   return new APIResponse<>(book);
  }

  @PutMapping("/{id}")
  public APIResponse<Book> updateBookResource(@PathVariable int id,@RequestBody String name){
    Book book = bookService.updateBookResource(id,name);
    return new APIResponse<>(book);
  }


}
