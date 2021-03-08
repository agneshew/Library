package com.agnes.Library.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String title;
    private Short yearOfPublish;
    private boolean borrowed;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

    @OneToOne (cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;




}
