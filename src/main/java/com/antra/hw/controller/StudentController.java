package com.antra.hw.controller;

import com.antra.hw.model.Student;
import com.antra.hw.model.TeacherStudent;
import com.antra.hw.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> listStudents() {
        List<Student> students = studentService.listStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student stu = studentService.addStudent(student);
        return new ResponseEntity<>(stu, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student stu = studentService.updateStudent(student);
        return new ResponseEntity<>(stu, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

    @GetMapping("/{id}/teachers")
    public ResponseEntity<List<TeacherStudent>> listTeacherStudents(@PathVariable Long id) {
        List<TeacherStudent> teacherStudents = studentService.getTeacherStudentsByStudentId(id);
        log.info("The number of teachers for student(" + id + ") : " + teacherStudents.size());
        return new ResponseEntity<>(teacherStudents, HttpStatus.OK);
    }
}
