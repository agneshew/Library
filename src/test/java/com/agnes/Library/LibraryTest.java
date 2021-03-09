package com.agnes.Library;

import com.agnes.Library.model.Author;
import com.agnes.Library.model.Book;
import com.agnes.Library.repository.AuthorRepository;
import com.agnes.Library.repository.BookRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LibraryTest {

    @Autowired
    BookRepository bookRepository;
    AuthorRepository authorRepository;

    @Test
    public void testSaveBookWithAuthor() {
        //Given
        Book book = new Book("Lord of the rings", 2010, false);
        book.setAuthor(new Author("J.R.R.", "Tolkien"));
        //When
        bookRepository.save(book);
        int id = book.getId();
        //Then
        Assert.assertEquals(1, id);
        //CleanUp
        bookRepository.deleteAll();
        authorRepository.deleteAll();
    }

}
