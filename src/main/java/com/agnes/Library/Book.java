package com.agnes.Library;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Data
public class Book {

    @Id
    private String id;
    private String title;
    private String type;
    private Short yearOfPublish;
    private boolean borrowed;

    public Book() {

    }

    public Book(String title, String type, Short yearOfPublish, boolean borrowed) {
        this.title = title;
        this.type = type;
        this.yearOfPublish = yearOfPublish;
        this.borrowed = borrowed;
    }
}
