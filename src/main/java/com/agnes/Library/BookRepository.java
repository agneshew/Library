package com.agnes.Library;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByType(String type);
    List<Book> findByYearOfPublish(Short yearOfPublish);
    List<Book> findByBorrowed(boolean borrowed);
}
