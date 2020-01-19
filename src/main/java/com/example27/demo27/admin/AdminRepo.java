package com.example27.demo27.admin;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdminRepo extends CrudRepository <Admin, Integer> {

    List<Admin> findByNameAndPassword(String name, String password);


    @Transactional
    @Modifying
    @Query(value = "update student s set s.ban ='BAN' where s.id = (select id_student from student_book where CURDATE()-date_take>=1 )", nativeQuery = true)
    int ban();

    @Transactional
    @Modifying
    @Query(value = "update student s set s.ban =null where s.id = (select id_student from student_book where date_return  is  null) ", nativeQuery = true)
    int unBan();


}
