package com.agnes.Library.repository;

import com.agnes.Library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    /*List<Book> findByTitleContaining(String title);
    List<Book> findByType(String type);
    List<Book> findByYearOfPublish(Short yearOfPublish);
    List<Book> findByBorrowed(boolean borrowed);*/
}
