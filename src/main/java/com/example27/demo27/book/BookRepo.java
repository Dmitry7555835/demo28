package com.example27.demo27.book;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepo  extends CrudRepository<Book, Integer>  {

    List<Book> deleteById(int id);

    List<Book> findByName (String name);

}
