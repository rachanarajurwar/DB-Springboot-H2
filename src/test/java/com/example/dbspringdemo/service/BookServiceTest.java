package com.example.dbspringdemo.service;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.dbspringdemo.entity.Book;
import com.example.dbspringdemo.entity.GENERA;
import com.example.dbspringdemo.repository.BookRepository;
import com.example.dbspringdemo.service.impl.BookServiceImpl;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class BookServiceTest {

  @Mock
  BookRepository bookRepository;
  BookService bookService;
  AutoCloseable autoCloseable;
  Book book;


  @BeforeEach
  void setUp() {
    autoCloseable = MockitoAnnotations.openMocks(this);
    bookService = new BookServiceImpl(bookRepository);
    book = new Book("serviceTest", GENERA.FICTION);

  }

  @AfterEach
  void tearDown() throws Exception {
    autoCloseable.close();
  }

  @Test
  void getAllBooksWithPagination() {
  }

  @Test
  void getAllBooks() {
     mock(BookRepository.class);
     mock(Book.class);

    when(bookRepository.findAll()).thenReturn(List.of(book));
    assertThat(bookService.getAllBooks().get(0).getName()).isEqualTo(book.getName());

  }

  @Test
  void getById() {
  }

  @Test
  void createBookResource() {
  }

  @Test
  void updateBookResource() {
  }
}