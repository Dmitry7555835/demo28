package com.example27.demo27.Student;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {
    List<Student> findById(int id);

    List<Student> deleteById(int id);

    List<Student> findByNameAndPassword(String name, String password);

    @Query(value = "select name from book b where name=:nameBook and amount>0", nativeQuery = true)
    String selectBook(@Param("nameBook") String nameBook);

    @Query(value = "select b.name from book b where b.id in (select s.id_book from Student s where s.name=:studentName) and b.name =:nameBook", nativeQuery = true)
    String selectStudent(@Param("nameBook") String nameBook, @Param("studentName") String studentName);//проверка наличия книги на руках

    @Transactional
    @Modifying
    @Query(value = "update Student s set s.id_book = (select b.id from book b where b.name =  :nameBook), s.date_take=CURDATE(), s.amount=s.amount+1" +// Добавить skey uniq
            " where s.name = :studentName", nativeQuery = true)
    int takeBook(@Param("nameBook") String nameBook, @Param("studentName") String studentName);

    @Transactional
    @Modifying
    @Query(value = "update book b set b.amount=b.amount-1 where name=:nameBook", nativeQuery = true)
    int updateBookAmount(@Param("nameBook") String nameBook);

    @Transactional
    @Modifying
    @Query(value = "update book b set b.amount=b.amount+1 where name=:nameBook", nativeQuery = true)
    int returnBook(@Param("nameBook") String nameBook);

    @Transactional
    @Modifying
    @Query(value = "update Student s set s.id_book = 0, s.date_return=CURDATE(), s.amount=s.amount-1 where s.name = :studentName", nativeQuery = true)
    int returnStudent(@Param("studentName") String studentName);



}
