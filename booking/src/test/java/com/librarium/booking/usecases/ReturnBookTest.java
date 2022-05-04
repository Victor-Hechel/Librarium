package com.librarium.booking.usecases;

import com.librarium.booking.models.Rent;
import com.librarium.booking.repositories.RentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReturnBookTest {

    @Mock
    private RentRepository rentRepository;

    @InjectMocks
    private ReturnBook returnBook;

    @Test
    void shouldReturnBook() {
        //when
        Long id = 123L;
        Rent rent = createRentMock(id);
        when(this.rentRepository.findById(id)).thenReturn(Optional.of(rent));
        when(this.rentRepository.save(Mockito.any())).thenReturn(rent);

        //do
        Rent rentResult = returnBook.execute(id);

        //then
        assertEquals(rentResult.equals(rent), Boolean.TRUE);
        assertNotNull(rentResult.getReturnalDate());
    }

    // TODO: Bloquear devolver livro já devolvido

    private Rent createRentMock(Long id){
        Rent rent = new Rent();
        rent.setId(id);
        return rent;
    }
}