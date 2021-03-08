package com.agnes.Library.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member  {

    @Id
    @NotNull
    @Column(name = "PESEL", unique = true)
    private int pesel;

    @NotNull
    @Column(name = "Phone number", unique = true)
    private int phoneNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToOne
    private Book book;



}
