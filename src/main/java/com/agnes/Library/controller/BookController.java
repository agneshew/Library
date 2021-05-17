package com.agnes.Library.controller;

import com.agnes.Library.service.BookService;
import com.agnes.Library.model.Book;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BookController {

    private BookService bookService;

    @GetMapping("/books/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=books_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        bookService.exportBooksToFile();
    }

    @GetMapping("/books")
    public ResponseEntity<Iterable<Book>> getAllBooksFromDB() {
        return ResponseEntity.ok(bookService.getAllBooksFromDB());
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }
    @PostMapping("/books/addNewBook")
    public ResponseEntity<Book> addNewBook(@RequestBody Book book) {
        book = bookService.addBookToDB(book);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/getBookById")
                .path("/{id}")
                .buildAndExpand(book.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    @PutMapping("/books/update/{id}")
    public ResponseEntity<Book> updateBookById(@RequestBody Book book, @PathVariable Integer id) {
        Book updatedBook = bookService.updateBookInDB(book);
        return ResponseEntity.ok(updatedBook);
    }
    @DeleteMapping("/books/delete/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}



