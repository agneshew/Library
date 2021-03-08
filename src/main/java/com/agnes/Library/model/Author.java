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
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private int id;
    @NotNull
    @Column(name="FIRST NAME")
    private String firstName;
    @NotNull
    @Column(name="LAST NAME")
    private String lastName;
    @OneToMany
    private List<Book> books;
}
