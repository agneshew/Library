package com.agnes.Library.service;

import com.agnes.Library.model.Book;
import com.agnes.Library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public Book getSingleBook(int id) {
        return bookRepository.findById(id)
                .orElseThrow();
    }
}



