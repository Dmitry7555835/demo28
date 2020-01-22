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

    @Transactional
    @Modifying
    @Query(value = "insert into student (name,password,date_reg) select :studentName,:studentpassword, current_date ()",nativeQuery = true)
    int studentadd ( @Param("studentName") String studentName, @Param("studentpassword") String studentpassword);

    @Query("select s.id from  Student s where s.name=:studentName and s.password=:studentpassword")
    int studentId ( @Param("studentName") String studentName, @Param("studentpassword") String studentpassword);



    @Query("select UPPER(b.name) from Book b where UPPER(b.name)=:nameBook and b.amount>0")                      //+++++++++++++++++++++++++
    String selectBook(@Param("nameBook") String nameBook);


    @Query("select sb.name_Book from StudentBook sb where sb.id_Student=:studentId  and sb.name_Book=:nameBook and sb.flag='N'")
    String selectStudent(@Param("nameBook") String nameBook, @Param("studentId") int studentId);

    @Transactional
    @Modifying
    @Query(value = "insert into student_book (date_take,date_return, id_student,name_book, flag) " +
            "select current_date,date_add(current_date, interval 14 day ), s.id, b.name, 'N' from student s RIGHT JOIN book b on " +
            "s.id = :studentId  and  b.name = :nameBook where s.id is not null and b.name is not null", nativeQuery = true)
    int takeBook(@Param("nameBook") String nameBook, @Param("studentId") int studentId);

    @Transactional
    @Modifying
    @Query("update Book b set b.amount=b.amount-1 where UPPER(b.name)=:nameBook")    //++++++++++++++++++++
    int updateBookAmount(@Param("nameBook") String nameBook);

    @Transactional
    @Modifying
    @Query("update Book b set b.amount=b.amount+1 where UPPER(b.name)=:nameBook")     //++++++++++++++++++++
    int returnBook(@Param("nameBook") String nameBook);

    @Transactional
    @Modifying
    @Query("update StudentBook sb set sb.date_return =current_date, sb.flag='Y'   where sb.id_Student = :idStudent and  sb.name_Book = :nameBook")    //+++++++++++++++++++++++
    int returnStudent(@Param("nameBook") String nameBook,@Param("idStudent") int idStudent);

    @Query("select sb from StudentBook sb where sb.id_Student=:idStudent and sb.flag='N'")                 //++++++++++++++
    Iterable<StudentBook> myBook(@Param("idStudent") int idStudent);

}
