package com.example27.demo27.Student;

import com.example27.demo27.Student.Student;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    @Query("update Student s set id_book = :id_book where id = :id_student")
    public void  updateBook(@Param("id_student")int id_student, @Param("id_book")int id_book );



}
