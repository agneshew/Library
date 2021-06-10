package com.agnes.Library.service;

import com.agnes.Library.config.BookExcelExporter;
import com.agnes.Library.model.*;
import com.agnes.Library.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Component
@AllArgsConstructor
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    private AuthorService authorService;


    public Book addBookToDB(Book book) {
        Optional<Integer> authorId = Optional.ofNullable(book.getAuthor().getId());
        if (authorId.isPresent()) {
            Optional<Author> optionalAuthor = authorService.isAuthorExistInDatabase(authorId.get());
            if (optionalAuthor.isPresent()) {
                Author author = optionalAuthor.get();
                author.addBook(book);
                book.setAuthor(author);
            } else {
                Author newAuthor = authorService.addAuthor(book.getAuthor().getFirstName(), book.getAuthor().getLastName());
                book.setAuthor(newAuthor);
            }
        }
        return bookRepository.save(book);
    }

    public Iterable<Book> getAllBooksFromDB() {
        return bookRepository.findAll(PageRequest.of(0, 5));
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElseGet(() -> null);
    }

    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }

    public Book updateBookInDB(Book book) {
        Optional<Book> bookOptional = Optional.ofNullable(getBookById(book.getId()));
        if (bookOptional.isPresent()) {
            Book updatedBook = bookOptional.get();
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setTitle(book.getTitle());
            addBookToDB(updatedBook);
        } else {
            addBookToDB(book);
        }
        return null;
    }

    public void exportBooksToFile() {
        Iterable<Book> bookIterable = getAllBooksFromDB();
        BookExcelExporter bookExcelExporter = new BookExcelExporter(bookIterable);
        bookExcelExporter.export();
    }
}
