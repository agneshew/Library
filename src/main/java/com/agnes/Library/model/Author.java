package com.agnes.Library.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Author {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    @OneToMany
    private List<Book> books;
}
