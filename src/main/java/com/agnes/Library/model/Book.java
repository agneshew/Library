package com.agnes.Library.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private int yearOfPublish;
    private boolean borrowed;


    @Column(columnDefinition = "enum('EBOOK','AUDIOBOOK','PAPER')")
    @Enumerated(EnumType.STRING)
    private BookType bookType;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne (cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    public Book(String title, int yearOfPublish,
                boolean borrowed, Author author,
                BookType bookType) {
        this.title = title;
        this.yearOfPublish = yearOfPublish;
        this.borrowed = borrowed;
        this.author = author;
        this.bookType = bookType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) &&
                author.equals(book.author) && bookType.equals(book.bookType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, bookType);
    }
}
