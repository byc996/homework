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
        Optional<Student> student = studentService.getStudentById(id);
        if (!student.isPresent()) {
            log.error("student(" + id + ") does not exist");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student.get());
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> listStudents() {
        List<Student> students = studentService.listStudents();
        log.info("Number of students: " + students.size());
        return ResponseEntity.ok(students);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student stu = studentService.addStudent(student);
        return new ResponseEntity<>(stu, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student stu = studentService.updateStudent(student);
        return ResponseEntity.ok(stu);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudentById(id);
        } catch (Exception e) {
            log.error("Fail to delete student " + id + " ." + e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Successfully deleted student " + id);
    }

    @GetMapping("/{id}/teachers")
    public ResponseEntity<List<TeacherStudent>> listTeacherStudents(@PathVariable Long id) {
        List<TeacherStudent> teacherStudents = studentService.getTeacherStudentsByStudentId(id);
        return ResponseEntity.ok(teacherStudents);
    }
}
