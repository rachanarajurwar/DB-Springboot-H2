package com.example.dbspringdemo.controller;


import com.example.dbspringdemo.entity.Address;
import com.example.dbspringdemo.entity.Book;
import com.example.dbspringdemo.entity.GENERA;
import com.example.dbspringdemo.entity.Library;
import com.example.dbspringdemo.entity.User;
import com.example.dbspringdemo.repository.AddressRepository;
import com.example.dbspringdemo.repository.BookRepository;
import com.example.dbspringdemo.repository.LibraryRepository;
import com.example.dbspringdemo.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/try")
@RequiredArgsConstructor
public class TryJPAController {

    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

     @PostMapping
     private String createBookLibrary(@RequestBody Book request){
       Library lib = new Library();
       lib.setId(123);
       lib.setName("Library No 1");

       Address address = new Address();
       address.setId(221);
       address.setCity("Pleasanton");
       address.setState("California");
       addressRepository.save(address);

       lib.setAddress(address);
          Book book1 = new Book("kid book of lib1", GENERA.KIDS);
          Book book2 = new Book("Fiction book lib1", GENERA.FICTION);
       book1.setLibrary(lib);
       book2.setLibrary(lib);



       libraryRepository.save(lib);
       bookRepository.save(book1);
       bookRepository.save(book2);

       Library lib2 = new Library();
       lib2.setId(234);
       lib2.setName("Library No 2");
       libraryRepository.save(lib2);
       Library lib3 = new Library();
       lib3.setId(345);
       lib3.setName("Library No 3");
       libraryRepository.save(lib3);

       User user1 = new User();
       user1.setId(1212);
       user1.setName("user 1");
       List<Library> user1Lib = List.of(lib,lib2);
       user1.setLibraryList(user1Lib);
       userRepository.save(user1);



           return "Success";
     }



}
