package com.agnes.Library.service;

import com.agnes.Library.model.Author;
import com.agnes.Library.repository.AuthorRepository;

import java.util.Optional;

public class AuthorService {

    private AuthorRepository authorRepository;


    public Author getAuthorById(int id) {
        return authorRepository.findById(id).orElseGet(() -> null);
    }

    public Optional<Author> isAuthorExistInDatabase(Integer authorId) {
        return Optional.ofNullable(getAuthorById(authorId));
    }
    public Author addAuthor(String firstName, String lastname) {
        return new Author(firstName, lastname);
    }

}
