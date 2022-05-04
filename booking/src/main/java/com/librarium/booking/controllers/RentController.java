package com.librarium.booking.controllers;

import com.librarium.booking.controllers.dto.RentRequest;
import com.librarium.booking.models.Rent;
import com.librarium.booking.usecases.RentBook;
import com.librarium.booking.usecases.ReturnBook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rent")
public class RentController {

    private final RentBook rentBook;
    private final ReturnBook returnBook;

    public RentController(RentBook rentBook, ReturnBook returnBook){
        this.rentBook = rentBook;
        this.returnBook = returnBook;
    }

    @PostMapping
    @ResponseBody
    public Rent rent(@RequestBody RentRequest request){
        return this.rentBook.execute(request.getLegalDocument(), request.getIsbn());
    }

    @PatchMapping("/return/{id}")
    @ResponseBody
    public Rent returnBook(@PathVariable Long id){
        return this.returnBook.execute(id);
    }

    // TODO: listar alugueis do cliente
}
