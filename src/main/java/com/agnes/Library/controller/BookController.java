package com.agnes.Library.controller;

import com.agnes.Library.model.Book;
import com.agnes.Library.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        try {
            List<Book> books = new ArrayList<Book>();
            bookRepository.findAll().forEach(books::add);

            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(books, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()) {
            return new ResponseEntity<>(bookOptional.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/book/newbook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        try {
            Book newBook = bookRepository.save(book);
            return new ResponseEntity<>(newBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @PutMapping("/books/{id}")
//    public ResponseEntity<Book> updateBook(@PathVariable("id") Integer id, @RequestBody Book book) {
//        Optional<Book> bookOptional = bookRepository.findById(id);
//
//        if (bookOptional.isPresent()) {
//            Book newBook = bookOptional.get();
//            newBook.setTitle(book.getTitle());
//            newBook.setBookType(book.getBookType());
//            newBook.setYearOfPublish(book.getYearOfPublish());
//            newBook.setBorrowed(book.isBorrowed());
//            return new ResponseEntity<>(bookRepository.save(newBook), HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    @DeleteMapping("books/{id}")
//    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id")Integer id) {
//        try {
//            bookRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}



