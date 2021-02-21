package com.agnes.Library.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class User {

    @Id
    private int pesel;
    private String firstName;
    private String lastName;
    @OneToOne
    private Book book;

}
