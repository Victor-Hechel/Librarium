package com.librarium.booking.usecases;

import com.librarium.booking.models.Rent;
import com.librarium.booking.repositories.RentRepository;
import com.librarium.booking.usecases.exceptions.BookAlreadyReturnedException;
import org.springframework.stereotype.Service;

@Service
public class ReturnBook {

    private final RentRepository rentRepository;

    public ReturnBook(RentRepository rentRepository){
        this.rentRepository = rentRepository;
    }

    public Rent execute(Long id){

        Rent rent = this.rentRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        if(rent.wasReturned()){
            throw new BookAlreadyReturnedException();
        }

        rent.returnBook();

        return this.rentRepository.save(rent);
    }
}
