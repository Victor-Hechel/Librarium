package com.librarium.booking.controllers;

import com.librarium.booking.controllers.dto.RentRequest;
import com.librarium.booking.models.Rent;
import com.librarium.booking.usecases.RentBook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rent")
public class RentController {

    private final RentBook rentBook;

    public RentController(RentBook rentBook){
        this.rentBook = rentBook;
    }

    @PostMapping
    @ResponseBody
    public Rent rent(@RequestBody RentRequest request){
        return this.rentBook.execute(request.getLegalDocument(), request.getIsbn());
    }
}
