package com.librarium.booking.usecases;

import com.librarium.booking.models.Book;
import com.librarium.booking.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListBooks {

    @Autowired
    BookRepository bookRepository;

    public List<Book> listBooks(int page) {
        PageRequest pageRequest = PageRequest.of(page, 3);
        Page<Book> pageBook = bookRepository.findAll(pageRequest);
        return pageBook.getContent();
    }
}
