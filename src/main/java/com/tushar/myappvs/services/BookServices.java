package com.tushar.myappvs.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tushar.myappvs.dao.BookRepository;
import com.tushar.myappvs.entities.Book;


@Component //to give permission to acces BookController class
public class BookServices {

  @Autowired
  private BookRepository bookRepository;
  
  

   //  private static List<Book> list = new ArrayList<>();
   //   static{
   //      list.add(new Book(1,"java","XYZ"));
   //      list.add(new Book(12,"python","ABC"));
   //      list.add(new Book(34,"C language","MNO"));

   //   }
     //get  all books information
     public List<Book> getAllBooks(){
       List<Book> list = (List<Book>) this.bookRepository.findAll();
       return list;
      
     }
     // get single book by id
     public Book getBookById(int id){
        Book book= null;
        try{
        // book = list.stream().filter(e->e.getId()==id).findFirst().get();
       book =  this.bookRepository.findById(id);
        }
        catch(Exception e){
         e.printStackTrace();
        }
      
       return book;

     }
     //adding the book
     public Book addBook(Book b){
       Book result = bookRepository.save(b);
      return result;
     }

     //deleting the book
     public void deletebook(int bookid){
     // list.stream().filter(e ->e.getId()!=bookid).collect(Collectors.toList());
     bookRepository.deleteById(bookid);
     }
     //updating the  book
      public void updatebook(Book b,int id){
         // list.stream().map(e->{
         //    if(e.getId()==id){
         //       e.setAuthor(b.getAuthor());
         //       e.setTitle(b.getTitle());
         //    }


         //    return e;
         // }).collect(Collectors.toList());
         b.setId(id);
         bookRepository.save(b);
      }

     }

