package com.example.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class BookController {
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return Collections.singletonList(new Book("Running rest", "new guy", 1L));
    }
}
