package com.agnes.Library.model;

import javax.validation.constraints.NotNull;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AUTHOR")
public final class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @OneToMany(targetEntity = Book.class,
            mappedBy = "author",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
