package com.agnes.Library.DB;

import com.agnes.Library.model.Author;
import com.agnes.Library.model.Book;
import com.agnes.Library.model.Member;
import com.agnes.Library.repository.AuthorRepository;
import com.agnes.Library.repository.BookRepository;
import com.agnes.Library.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DatabaseManager {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private MemberRepository memberRepository;

    public Author getAuthorById(int id) {
        return authorRepository.findById(id).orElseGet(() -> null);
    }

    public void addBookToDB(Book book) {
        bookRepository.save(book);
    }
    public void deleteBookFromDB(Book book) {
        bookRepository.delete(book);
    }
    public Iterable<Book> getAllBooksFromDB() {
        return bookRepository.findAll();
    }
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElseGet(() -> null);
    }
    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
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

