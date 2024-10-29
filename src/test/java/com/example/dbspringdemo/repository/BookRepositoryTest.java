package com.example.dbspringdemo.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.example.dbspringdemo.entity.Book;
import com.example.dbspringdemo.entity.GENERA;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@TestPropertySource(properties = "spring.config.location=classpath:/application.yaml")
public class BookRepositoryTest {

  @Autowired
  private BookRepository bookRepository;
  private Book book;

  @AfterEach
  void tearDown() {
    book=null;
    bookRepository.deleteAll();
  }

  @BeforeEach
  void setUp() {
    book = new Book("testing book1", GENERA.KIDS);
    bookRepository.save(book);
  }

  @Test
  public void testFindByName_found(){

   List<Book> books= bookRepository.findByName("testing book1");
   assertThat(books.get(0).getName()).isEqualTo("testing book1");

  }

  @Test
  public void testFindByName_notfound(){

    List<Book> books= bookRepository.findByName("lucky me");
    assertThat(books.isEmpty()).isTrue();

  }

  /*
  *     void testDeleteCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository)
                .deleteById(any());
        assertThat(cloudVendorService.deleteCloudVendor("1")).isEqualTo("Success");
    }*/
}
