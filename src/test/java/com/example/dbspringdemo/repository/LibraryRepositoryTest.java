package com.example.dbspringdemo.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.dbspringdemo.entity.Library;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@TestPropertySource(properties = "spring.config.location=classpath:/application.yaml")
class LibraryRepositoryTest {

  @Autowired
  private LibraryRepository libraryRepository;
  Library library;

  @BeforeEach
  void setUp() {
    library= new Library();
    library.setId(123);
    library.setName("Library1");
    libraryRepository.save(library);
  }

  @AfterEach
  void tearDown() {
    library = null;
    libraryRepository.deleteAll();
  }

  @Test
  public void testFindByName(){

    Library l = libraryRepository.findByName("Library1");
    assertThat(l.getName()).isEqualTo("Library1");

  }

}