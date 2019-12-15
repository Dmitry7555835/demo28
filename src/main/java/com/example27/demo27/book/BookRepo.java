package com.example27.demo27.book;

import com.example27.demo27.Student.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book, Integer> {

        List<Book>deleteById(int id);

        List<Book>findByName(String name);



}
