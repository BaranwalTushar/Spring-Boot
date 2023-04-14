package com.tushar.myappvs.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        try{
         book = list.stream().filter(e->e.getId()==id).findFirst().get();
        }
        catch(Exception e){
         e.printStackTrace();
        }
      
       return book;

     }
     //adding the book
     public Book addBook(Book b){
      list.add(b);
      return b;
     }

     //deleting the book
     public void deletebook(int bookid){
      list.stream().filter(e ->e.getId()!=bookid).collect(Collectors.toList());
     }
     //updating the  book
      public void updatebook(Book b,int id){
         list.stream().map(e->{
            if(e.getId()==id){
               e.setAuthor(b.getAuthor());
               e.setTitle(b.getTitle());
            }


            return e;
         }).collect(Collectors.toList());
      }

     }

