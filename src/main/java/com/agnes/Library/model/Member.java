package com.agnes.Library.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member  {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private int phoneNumber;
    @NotNull
    private String email;

    @OneToOne(cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    private Book book;

    public Member(String firstName, String lastName,
                  int phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
