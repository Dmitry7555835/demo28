package com.example27.demo27.admin;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRepo extends CrudRepository <Admin, Integer> {

    List<Admin> findByNameAndPassword(String name, String password);
}
