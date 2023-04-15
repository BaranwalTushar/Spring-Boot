package com.tushar.myappvs.dao;

import org.springframework.data.repository.CrudRepository;

import com.tushar.myappvs.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{
    public Book findById(int id);
 
}
