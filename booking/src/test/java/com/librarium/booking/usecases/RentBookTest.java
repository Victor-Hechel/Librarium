package com.librarium.booking.usecases;

import com.librarium.booking.models.Book;
import com.librarium.booking.models.Rent;
import com.librarium.booking.models.User;
import com.librarium.booking.repositories.BookRepository;
import com.librarium.booking.repositories.RentRepository;
import com.librarium.booking.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentBookTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RentRepository rentRepository;

    @InjectMocks
    private RentBook rentBook;

    @Test
    public void shouldSaveRent(){
        String isbn = "123";
        String legalDocument = "456";
        Book bookFound = new Book(isbn);
        when(this.bookRepository.findById(isbn)).thenReturn(Optional.of(bookFound));
        User userFound = new User(legalDocument);
        when(this.userRepository.findById(legalDocument)).thenReturn(Optional.of(userFound));

        Rent saved = new Rent();
        saved.setId(1L);
        saved.setBook(bookFound);
        saved.setUser(userFound);
        saved.setDate(LocalDateTime.now());
        when(this.rentRepository.save(any(Rent.class))).thenReturn(saved);

        Rent returned = this.rentBook.execute(legalDocument, isbn);

        assertNotNull(returned.getId());
        assertEquals(returned.getBook().getIsbn(), isbn);
        assertEquals(returned.getUser().getCpf(), legalDocument);
        assertNotNull(returned.getDate());
    }

    // TODO: Bloquear alugar livro que esteja alugado pelo cliente

}