package com.yusufsahin.services.impl;

import com.yusufsahin.dto.DtoStudent;
import com.yusufsahin.dto.DtoStudentIU;
import com.yusufsahin.entities.Student;
import com.yusufsahin.repository.StudentRepository;
import com.yusufsahin.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired //Field Injection (Alternative : Constuctor Injection)
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU, student); // DTO -> Entity
        student = studentRepository.save(student);

        DtoStudent dtoStudent = new DtoStudent();
        BeanUtils.copyProperties(student, dtoStudent); // Entity -> DTO
        return dtoStudent;
    }

    //BeanUtils.copyProperties(Alternatives: Manuel(Get-Set), MapStruct)

    @Override
    public List<DtoStudent> getAllStudent() {
        List<Student> students = studentRepository.findAll(); // OR findAllStudents(Custom Query Method)
        List<DtoStudent> dtoStudents = new ArrayList<>();

        for (Student student : students) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            dtoStudents.add(dtoStudent);
        }
        return dtoStudents;
    }

    @Override
    public DtoStudent getStudentById(int id) {
        Optional<Student> optional = studentRepository.findById(id);

        if (optional.isPresent()) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(optional.get(), dtoStudent);
            return dtoStudent;
        }
        return null;
    }

    @Override
    public void deleteStudent(int id) {
        if (studentRepository.existsById(id))
            studentRepository.deleteById(id);
    }

    @Override
    public DtoStudent updateStudent(int id, DtoStudentIU dtoUpdateStudentIU) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student dbStudent = optionalStudent.get();

            if (dtoUpdateStudentIU.getFirstName() != null)
                dbStudent.setFirstName(dtoUpdateStudentIU.getFirstName());

            if (dtoUpdateStudentIU.getLastName() != null)
                dbStudent.setLastName(dtoUpdateStudentIU.getLastName());

            if (dtoUpdateStudentIU.getBirthOfDate() != null)
                dbStudent.setBirthOfDate(dtoUpdateStudentIU.getBirthOfDate());

            dbStudent = studentRepository.save(dbStudent);

            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(dbStudent, dtoStudent);
            return dtoStudent;
        }
        return null;
    }

}
