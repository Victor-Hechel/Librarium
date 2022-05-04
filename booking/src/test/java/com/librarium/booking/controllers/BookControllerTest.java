package com.librarium.booking.controllers;

import com.librarium.booking.models.Book;
import com.librarium.booking.usecases.ListBooks;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ListBooks listBooks;

    @Test
    void listBooks() throws Exception {
        List<Book> booksTest = Arrays.asList(
                new Book("123"),
                new Book("456"),
                new Book("789")
        );

        when(listBooks.listBooks(Mockito.anyInt())).thenReturn(booksTest);

        this.mockMvc.perform(get("/book/all").param("page", "0"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(3)));

        verify(listBooks, times(1)).listBooks(Mockito.anyInt());

    }

    // TODO: Testar rent

    // TODO: Testar return
}