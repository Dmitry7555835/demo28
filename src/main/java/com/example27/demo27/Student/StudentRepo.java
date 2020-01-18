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

    @Query(value = "select UPPER(name) from book b where UPPER(name)=:nameBook and amount>0", nativeQuery = true)
    String selectBook(@Param("nameBook") String nameBook);

    @Query(value = "select UPPER(b.name) from book b where b.name in " +
            "(select sb.name_book from student_Book sb where sb.id_student in " +
            "(select id from student s where name =:studentName) and date_return is null) " +
            "and b.name =:nameBook", nativeQuery = true)
    String selectStudent(@Param("nameBook") String nameBook, @Param("studentName") String studentName);//проверка наличия книги на руках

    @Transactional
    @Modifying
    @Query(value = "insert into student_Book (date_take, id_student,name_book) " +
            "select curdate(), s.id, b.name from student s RIGHT JOIN book b on s.id = :studentId  and  b.name = :nameBook where s.id is not null and b.name is not null", nativeQuery = true)
    int takeBook(@Param("nameBook") String nameBook, @Param("studentId") int studentId);


    @Transactional
    @Modifying
    @Query(value = "update book b set b.amount=b.amount-1 where UPPER(b.name)=:nameBook", nativeQuery = true)
    int updateBookAmount(@Param("nameBook") String nameBook);

    @Transactional
    @Modifying
    @Query(value = "update book b set b.amount=b.amount+1 where UPPER(name)=:nameBook", nativeQuery = true)
    int returnBook(@Param("nameBook") String nameBook);

    @Transactional
    @Modifying
    @Query(value = "update student_Book sb set sb.date_return =CURDATE()  where sb.id_Student = :idStudent and  sb.name_book = :nameBook", nativeQuery = true)
    int returnStudent(@Param("nameBook") String nameBook,@Param("idStudent") int idStudent);

    @Query(value ="select  sb.name_book, sb.date_take,sb.date_return from student_Book sb where  sb.id_Student = :idStudent and date_return is not null", nativeQuery = true)
    List<StudentBook>  myBook(@Param("idStudent") int idStudent);

}
