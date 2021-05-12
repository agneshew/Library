package com.agnes.Library.service;

import com.agnes.Library.config.BookExcelExporter;
import com.agnes.Library.model.Author;
import com.agnes.Library.model.Book;
import com.agnes.Library.model.Member;
import com.agnes.Library.repository.AuthorRepository;
import com.agnes.Library.repository.BookRepository;
import com.agnes.Library.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
@Component
@AllArgsConstructor
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    private MemberRepository memberRepository;
    private AuthorRepository authorRepository;

    public Author getAuthorById(int id) {
        return authorRepository.findById(id).orElseGet(() -> null);
    }
    private Optional<Author> isAuthorExistInDatabase(Integer authorId) {
        return Optional.ofNullable(getAuthorById(authorId));
    }
    private Author addAuthor(String firstName, String lastname) {
        return new Author(firstName, lastname);
    }
    public void addBookToDB(Book book) {
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
        bookRepository.save(book);
    }
    public Iterable<Book> getAllBooksFromDB() {
        return bookRepository.findAll(PageRequest.of(0,5));
    }
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElseGet(() -> null);
    }
    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }
    public void updateBookInDB(Book book) {
        Optional<Book> bookOptional = Optional.ofNullable(getBookById(book.getId()));
        if (bookOptional.isPresent()) {
            Book updatedBook = bookOptional.get();
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setTitle(book.getTitle());
            addBookToDB(updatedBook);
        } else {
            addBookToDB(book);
        }
    }
    public void exportBooksToFile () {
        Iterable<Book> bookIterable = getAllBooksFromDB();
        BookExcelExporter bookExcelExporter = new BookExcelExporter(bookIterable);
        bookExcelExporter.export();
    }
    public void addMemberToDB(Member member) {
        memberRepository.save(member);
    }
    public void deleteMemberFromDB(Member member) {
        memberRepository.delete(member);
    }
    public Member getMemberById(int id) {
        return memberRepository.findById(id).orElseGet(() -> null);
    }
}

