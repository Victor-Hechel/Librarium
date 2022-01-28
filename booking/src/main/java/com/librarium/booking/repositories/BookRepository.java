package com.librarium.booking.repositories;

import com.librarium.booking.models.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, String> {

}
