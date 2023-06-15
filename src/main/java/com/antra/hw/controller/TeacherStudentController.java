package com.antra.hw.controller;

import com.antra.hw.model.Teacher;
import com.antra.hw.model.TeacherStudent;
import com.antra.hw.service.TeacherStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher_student")
public class TeacherStudentController {

    private final TeacherStudentService teacherStudentService;

    @Autowired
    public TeacherStudentController(TeacherStudentService teacherStudentService) {
        this.teacherStudentService = teacherStudentService;
    }


    @GetMapping("/list")
    public ResponseEntity<List<TeacherStudent>> listTeacherStudents() {
        List<TeacherStudent> teacherStudents = teacherStudentService.listTeacherStudents();
        return new ResponseEntity<>(teacherStudents, HttpStatus.OK);
    }
}
