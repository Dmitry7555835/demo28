package com.example27.demo27.Student;

import com.example27.demo27.Student.Student;
import org.springframework.data.repository.CrudRepository;



import java.util.List;

public interface StudentRepo extends CrudRepository<Student, Integer> {
    List<Student> findById(int id);

    List<Student> deleteById(int id);

    List<Student> findByNameAndPassword(String name, String password);
}
