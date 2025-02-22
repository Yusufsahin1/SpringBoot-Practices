package com.yusufsahin.controller;

import com.yusufsahin.dto.DtoStudent;
import com.yusufsahin.dto.DtoStudentIU;
import com.yusufsahin.entities.Student;

import java.util.List;

public interface IStudentController {

    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);

    public List<DtoStudent> getAllStudent();

    public DtoStudent getStudentById(int id);

    public void deleteStudent(int id);

    public DtoStudent updateStudent(int id, DtoStudentIU updateDtoStudentIU);
}
