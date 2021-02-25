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
public class Author extends User {

    @Id
    private int id;
    @OneToMany
    private List<Book> books;

}
