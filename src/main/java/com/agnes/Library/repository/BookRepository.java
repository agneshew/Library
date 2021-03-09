package com.agnes.Library.repository;

import com.agnes.Library.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findByBorrowed(boolean borrowed);
}
