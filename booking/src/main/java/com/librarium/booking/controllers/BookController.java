package com.librarium.booking.controllers;

import com.librarium.booking.models.Book;
import com.librarium.booking.usecases.ListBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    ListBooks listBooks;

    @GetMapping("/all")
    @ResponseBody
    public List<Book> listBooks(@RequestParam int page){
        return listBooks.listBooks(page);
    }
}
