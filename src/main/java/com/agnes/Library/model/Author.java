package com.agnes.Library.model;

import javax.validation.constraints.NotNull;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Setter
@Entity
@Table(name = "AUTHOR")
@AllArgsConstructor
@NoArgsConstructor
public final class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @OneToMany(mappedBy = "author", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Book> books;

    public void addBook(Book book) {
        books.add(book);
    }
}
