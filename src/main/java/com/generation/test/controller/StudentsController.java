package com.generation.test.controller;

import com.generation.test.model.Students;
import com.generation.test.service.StudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentsController {

    private final StudentsService studentsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Students createStudent(@RequestBody Students students) {
        return studentsService.createStudent(students);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Students> findAllStudents() {
        return studentsService.findAllStudents();
    }

    @GetMapping("/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Students findStudentById(@PathVariable Long studentId) {
        return studentsService.findStudentById(studentId);
    }

    @PutMapping("/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Students updateStudent(@PathVariable Long studentId, @RequestBody Students students) {
        return studentsService.updateStudents(studentId, students);
    }

    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long studentId) {
        studentsService.deleteStudent(studentId);
    }
}
