package com.agnes.Library;

import com.agnes.Library.model.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelTest {
    @Test
    public void shouldCreateAuthor() {
        //Given
        Author author = new Author("JRR", "Tolkien");
        //When&Then
        assertNotNull(author);
        assertEquals("JRR", author.getFirstName());
        assertEquals("Tolkien", author.getLastName());
    }
}


