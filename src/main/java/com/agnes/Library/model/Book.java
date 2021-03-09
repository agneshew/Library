package com.agnes.Library.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String title;
    private int yearOfPublish;
    private boolean borrowed;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne (cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    public Book(@NotNull String title, int yearOfPublish,
                boolean borrowed) {
        this.title = title;
        this.yearOfPublish = yearOfPublish;
        this.borrowed = borrowed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
