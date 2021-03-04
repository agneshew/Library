package com.agnes.Library.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.naming.ldap.PagedResultsControl;
import javax.persistence.*;
import java.util.List;


@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AUTHOR")
public class Author {

    private int id;
    private String firstName;
    private String lastName;
    @OneToMany
    private List<Book> books;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "FIRST NAME")
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    @Column(name = "LAST NAME")
    public String getLastName() {
        return lastName;
    }

    public List<Book> getBooks() {
        return books;
    }
}
