package com.librarium.booking.usecases;

import com.librarium.booking.models.Book;
import com.librarium.booking.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class ListBooksTest {

    @Mock
    private BookRepository bookRepository;

    @Autowired
    private ListBooks listBooks;

    @Test
    public void shouldReturnThreeBooks() {
        Mockito.when(bookRepository.findAll(Mockito.any(Pageable.class)))
                .thenReturn(new PageImpl<>(
                    Arrays.asList(
                            new Book("123"),
                            new Book("456"),
                            new Book("789")
                    )
                ));

        List<Book> books = listBooks.listBooks(0);

        assertEquals(3, books.size());
        assertNotEquals(books.get(0).getIsbn(), books.get(1).getIsbn());
    }

}
