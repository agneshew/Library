package com.agnes.Library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Member  {

    @Id
    private int pesel;
    private int phoneNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToOne
    private Book book;

}
