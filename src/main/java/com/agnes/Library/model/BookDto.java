package com.agnes.Library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class BookDto {
    private int id;
    private String title;
    private Short yearOfPublish;
    private boolean borrowed;
}
