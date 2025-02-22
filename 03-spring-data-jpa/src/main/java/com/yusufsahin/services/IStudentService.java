package com.yusufsahin.services;

import com.yusufsahin.dto.DtoStudent;
import com.yusufsahin.dto.DtoStudentIU;
import com.yusufsahin.entities.Student;

import java.util.List;

public interface IStudentService {

    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);

    public List<DtoStudent> getAllStudent();

    public DtoStudent getStudentById(int id);

    public void deleteStudent(int id);

    public DtoStudent updateStudent(int id, DtoStudentIU updateDtoStudentIU);
}
