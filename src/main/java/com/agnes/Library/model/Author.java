package com.agnes.Library.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public final class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @OneToMany(targetEntity = Book.class,
            mappedBy = "author",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private Set<Book> books = new HashSet<>();

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
//    public void addBook(Book book) {
//        books.add(book);
//    }
    @Override
    public String toString() {
        return firstName + " " + lastName ;
    }
}
