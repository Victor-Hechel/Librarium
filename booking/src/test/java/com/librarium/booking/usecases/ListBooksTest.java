package com.librarium.booking.usecases;

import com.librarium.booking.models.Book;
import com.librarium.booking.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ListBooksTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private ListBooks listBooks;

    @Test
    public void shouldReturnThreeBooks() {
        List<Book> allMockedBooks = createMockedBooks();

        Mockito.when(bookRepository.findAll(Mockito.any(Pageable.class)))
                .thenReturn(new PageImpl<>(allMockedBooks.subList(0, 3)));

        List<Book> books = listBooks.listBooks(0);

        assertEquals(3, books.size());
        assertNotEquals(books.get(0).getIsbn(), books.get(1).getIsbn());
        verify(bookRepository, times(1)).findAll(Mockito.any(Pageable.class));
    }

    private List<Book> createMockedBooks(){
        return Arrays.asList(
                new Book("123"),
                new Book("456"),
                new Book("789"),
                new Book("012"),
                new Book("345"),
                new Book("678")
        );
    }

}
