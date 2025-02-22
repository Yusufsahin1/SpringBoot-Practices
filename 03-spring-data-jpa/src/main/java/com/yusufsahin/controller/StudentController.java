package com.yusufsahin.controller;

import com.yusufsahin.dto.DtoStudent;
import com.yusufsahin.dto.DtoStudentIU;
import com.yusufsahin.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/api/student")
public class StudentController {

    //@Autowired // Field Injection (Not Best Practice)
    //private StudentService studentService;

    //Constructor Injection
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Another Alternative -> Setter Injection

    @PostMapping(path = "/save")
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU dtoStudentIU) {
        return studentService.saveStudent(dtoStudentIU);
    }

    @GetMapping(path = "/list")
    public List<DtoStudent> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping(path = "/list/{id}")
    public DtoStudent getStudentById(@PathVariable(name = "id") int id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteStudent(@PathVariable(name = "id") int id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "/update/{id}")
    public DtoStudent updateStudent(@PathVariable(name = "id") int id, @RequestBody DtoStudentIU updateDtoStudentIU) {
        return studentService.updateStudent(id, updateDtoStudentIU);
    }
}
