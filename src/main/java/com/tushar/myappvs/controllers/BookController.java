package com.tushar.myappvs.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.myappvs.entities.Book;
import com.tushar.myappvs.services.BookServices;

@RestController
public class BookController {

    // for accessing single entity

// @GetMapping("/Books")
//   public Book getBooks(){
//     Book B = new Book();
//     B.setId(1);
//     B.setTitle("java");
//     B.setAuthor("xyz");
//     return B;
    @Autowired
    private BookServices bookServices;
    //for multiple book calling using (ArrayList<>)

     @GetMapping("/Books")
     public List<Book> getBooks(){
        return this.bookServices.getAllBooks();
     }
     // for single book by id 
     @GetMapping("/Books/{id}")
     public Book getBook(@PathVariable("id") int id){
        return bookServices.getBookById(id);
     }
    
  }
    

