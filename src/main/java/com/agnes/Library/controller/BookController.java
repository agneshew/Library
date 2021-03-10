package com.agnes.Library.controller;

import com.agnes.Library.DB.DatabaseManager;
import com.agnes.Library.model.Author;
import com.agnes.Library.model.Book;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BookController {

    private DatabaseManager databaseManager;

    private Author addAuthor(String firstName, String lastname) {
        return new Author(firstName, lastname);
    }
    private Optional<Author> isAuthorExistInDatabase(Integer authorId) {
        return Optional.ofNullable(databaseManager.getAuthorById(authorId));
    }

    @GetMapping("/books")
    public ResponseEntity<Iterable<Book>> getAllBooksFromDB() {
        return ResponseEntity.ok(databaseManager.getAllBooksFromDB());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        return ResponseEntity.ok(databaseManager.getBookById(id));

    }
    @PostMapping("/books/addNewBook")
    public ResponseEntity addNewBook(@RequestBody Book book) {

        Optional<Integer> authorId = Optional.ofNullable(book.getAuthor().getId());
        if(authorId.isPresent()) {
            Optional<Author> optionalAuthor = isAuthorExistInDatabase(authorId.get());
            if(optionalAuthor.isPresent()){
                Author author = optionalAuthor.get();
                author.addBook(book);
                book.setAuthor(author);
            }
            else{
                Author newAuthor = addAuthor(book.getAuthor().getFirstName(), book.getAuthor().getLastName());
                book.setAuthor(newAuthor);
            }
        }
        databaseManager.addBookToDB(book);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/getBookById")
                .path("/{id}")
                .buildAndExpand(book.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/books/update/{id}")
    public ResponseEntity updateBookById(@RequestBody Book book, @PathVariable Integer id) {

        Optional<Book> bookOptional = Optional.ofNullable(databaseManager.getBookById(id));
        if (bookOptional.isPresent()) {
            Book updatedBook = bookOptional.get();
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setTitle(book.getTitle());
            databaseManager.addBookToDB(updatedBook);
        } else {
            databaseManager.addBookToDB(book);
        }
        return ResponseEntity.ok("The book has been successfully saved");
    }

    @DeleteMapping("/books/delete/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable Integer id) {
        databaseManager.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}



