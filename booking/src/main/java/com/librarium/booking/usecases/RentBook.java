package com.librarium.booking.usecases;

import com.librarium.booking.models.Book;
import com.librarium.booking.models.Rent;
import com.librarium.booking.models.User;
import com.librarium.booking.repositories.BookRepository;
import com.librarium.booking.repositories.RentRepository;
import com.librarium.booking.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RentBook {
    private final BookRepository bookRepository;

    private final UserRepository userRepository;

    private final RentRepository rentRepository;

    public RentBook(
            BookRepository bookRepository,
            UserRepository userRepository,
            RentRepository rentRepository
    ){
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.rentRepository = rentRepository;
    }

    public Rent execute(String legalDocument, String isbn) {

        final int daysUntilDeadline = 10;

        Rent rent = new Rent();

        Book book = this.bookRepository.findById(isbn)
                .orElseThrow(IllegalArgumentException::new);

        User user = this.userRepository.findById(legalDocument)
                .orElseThrow(IllegalArgumentException::new);

        rent.setBook(book);
        rent.setUser(user);
        rent.setDaysUntilDeadline(daysUntilDeadline);
        rent.setDate(LocalDateTime.now());

        return this.rentRepository.save(rent);
    }
}
