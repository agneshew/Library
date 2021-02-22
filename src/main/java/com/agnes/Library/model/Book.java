package com.agnes.Library.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class Book {

    @Id
    private int id;
    private String title;
    private String type;
    private Short yearOfPublish;
    private boolean borrowed;
    @OneToOne
    private User user;


}
