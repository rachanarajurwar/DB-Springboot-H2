package com.example.dbspringdemo.service.impl;


import com.example.dbspringdemo.entity.Book;
import com.example.dbspringdemo.exception.ResourceNotFoundException;
import com.example.dbspringdemo.repository.BookRepository;
import com.example.dbspringdemo.service.BookService;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;


  //Load some data
 /* @PostConstruct
  private void init(){
    List<Book> bookList1 = IntStream.range(0,100).mapToObj( b -> new Book("Book Fiction"+b, Genera.FICTION)).collect(
        Collectors.toList());
    List<Book> bookList2 = IntStream.range(101,150).mapToObj( b -> new Book("Book Kids"+b, Genera.KIDS)).collect(
        Collectors.toList());
    List<Book> bookList3 = IntStream.range(151,200).mapToObj( b -> new Book("Book Thriller"+b, Genera.TRILLER)).collect(
        Collectors.toList());
    bookRepository.saveAll(bookList1);
    bookRepository.saveAll(bookList2);
    bookRepository.saveAll(bookList3);
  }*/

  @Override
  public Page<Book> getAllBooksWithPagination(int page, int limit, String sort) {

    Page<Book> products =  bookRepository.findAll(PageRequest.of(page,limit).withSort(Direction.DESC,sort));
    return products;

  }

  @Override
  public List<Book> getAllBooks() {
   return bookRepository.findAll();
  }

  @Override
  public Book getById(int id) {
    return bookRepository.findById(id).get();
  }


  @Override
  public Book createBookResource(Book book) {
    return bookRepository.save(book);
  }

  @Override
  public Book updateBookResource(int id, String name) {

    Book book = bookRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("Book id in request is incorrect"));
    book.setName(name);
    return bookRepository.save(book);
  }

  public List<Book> getBooksAsPerSpecification(String name, String genera){

  /*  Specification<Book> spec = (root, query, cb) -> {
     List<Predicate> predicates = new ArrayList<>();
      predicates.add(cb.equal(root.get("name"),name));
      predicates.add(cb.equal(root.get("genera"),"KIDS"));
      return cb.and(predicates.toArray(new Predicate[0]));
    };

    List<Book> books =bookRepository.findAll(spec);
    return books;*/

    return null;
  }

}
