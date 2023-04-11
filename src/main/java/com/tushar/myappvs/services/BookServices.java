package com.tushar.myappvs.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tushar.myappvs.entities.Book;

@Component //to give permission to acces BookController class
public class BookServices {

    private static List<Book> list = new ArrayList<>();
     static{
        list.add(new Book(1,"java","XYZ"));
        list.add(new Book(12,"python","ABC"));
        list.add(new Book(34,"C language","MNO"));

     }
     //get  all books information
     public List<Book> getAllBooks(){
        return list;
     }
     // get single book by id
     public Book getBookById(int id){
        Book book= null;
       book = list.stream().filter(e->e.getId()==id).findFirst().get();
       return book;

     }
    
}
