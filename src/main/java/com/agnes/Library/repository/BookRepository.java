package com.agnes.Library.repository;

import com.agnes.Library.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByType(String type);
    List<Book> findByYearOfPublish(Short yearOfPublish);
    List<Book> findByBorrowed(boolean borrowed);
}
