package com.agnes.Library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class BookType {

    @Id
    private int id;
    private String type;
    @OneToMany
    private List<Book> books;

}
