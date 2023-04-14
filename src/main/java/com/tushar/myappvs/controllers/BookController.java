package com.tushar.myappvs.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
      
     public ResponseEntity<List<Book>> getBooks(){

        List<Book> list = bookServices.getAllBooks();
        if(list.size()<=0){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
     }

     // for single book by id 
     @GetMapping("/Books/{id}")
     public ResponseEntity <Book> getBook(@PathVariable("id") int id){
      Book book = bookServices.getBookById(id);
      if(book == null){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      return ResponseEntity.of(Optional.of(book));

     }
     
       //for create book handler
     @PostMapping("/Books")

     public ResponseEntity <Book> addBook(@RequestBody Book book){
      Book b = null;
      try{
          b = this.bookServices.addBook(book);
          System.out.println(book);
          return ResponseEntity.of(Optional.of(b));
      }
      catch(Exception e){
         e.printStackTrace();
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
        
     }
     //for Delete book handler
     @DeleteMapping("/Books/{id}")

     public ResponseEntity<Void> deletebook(@PathVariable("id")int id){
      try{
         this.bookServices.deletebook(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
      }
      catch(Exception e){
         e.printStackTrace();
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
      

     }
     @PutMapping("/Books/{id}")
     //update book handler
     public  ResponseEntity <Book> updatebook(@RequestBody Book book,@PathVariable("id")int id){
      try{
         this.bookServices.updatebook(book,id);
         return ResponseEntity.ok().body(book);
      
      }
      catch(Exception e){
         e.printStackTrace();
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
      

     }


    
  }
    

