package com.yusufsahin.repository;

import com.yusufsahin.dto.DtoStudent;
import com.yusufsahin.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //HQL:Hibernate Query Language - Class name & Variable name - nativeQuery:False
    //SQL Structured Query Language - Table name & Column name - nativeQuery:True

    @Query(value = "from Student", nativeQuery = false)
    List<Student> findAllStudents();

    //@Query(value = "select * from student.student", nativeQuery = true) // Schema.Table
    //List<Student> findAllStudents();

}
