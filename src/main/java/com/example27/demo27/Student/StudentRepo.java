package com.example27.demo27.Student;

import com.example27.demo27.Student.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface StudentRepo  extends  CrudRepository<Student, Integer> {
    List<Student> findById(int id);

    List<Student> deleteById(int id);

    List<Student> findByNameAndPassword(String name, String password);

    @Transactional
    @Modifying
    @Query(value = "update Student s set s.id_book = (select b.id from book b where b.name =  :nameBook) where s.name = :studentName", nativeQuery = true)
    default void updateBook(@Param("nameBook") String nameBook, @Param("studentName") String studentName) {

    }


}
