package com.example27.demo27.admin;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdminRepo extends CrudRepository <Admin, Integer> {

    List<Admin> findByNameAndPassword(String name, String password);


    /*@Transactional
    @Modifying
    @Query(value = "insert into admin (id,name,password)  values (2, 'admin', 'admin')", nativeQuery = true)
    String AdminContr();*/


}
