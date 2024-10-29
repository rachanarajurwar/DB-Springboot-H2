package com.example.dbspringdemo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import com.example.dbspringdemo.entity.Book;
import com.example.dbspringdemo.entity.GENERA;
import com.example.dbspringdemo.service.BookService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(BookController.class)
class BookControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private BookService bookService;
  Book book1;
  Book book2;
  List<Book> bookList = new ArrayList<>();

  @BeforeEach
  void setUp() {
    book1=new Book("testing book1", GENERA.KIDS);
    book2=new Book("testing book2", GENERA.KIDS);
    bookList.add(book1);
    bookList.add(book2);
  }

  @Test
  void getAllBooks() throws Exception {
    when(bookService.getAllBooks()).thenReturn(bookList);
    this.mockMvc.perform(get("/books/all")).andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void getById() {
  }

  @Test
  void testGetAllBooks() {
  }

  @Test
  void createBookResource() {
  }

  @Test
  void updateBookResource() {
  }
}