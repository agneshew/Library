package com.agnes.Library.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Member extends User {

    @Id
    private int pesel;
    private int phoneNumber;
    private String email;
    private String password;
    @OneToOne
    private Book book;

}
