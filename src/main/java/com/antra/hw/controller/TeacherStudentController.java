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
@RequestMapping("/teacher_students")
public class TeacherStudentController {

    private final TeacherStudentService teacherStudentService;

    @Autowired
    public TeacherStudentController(TeacherStudentService teacherStudentService) {
        this.teacherStudentService = teacherStudentService;
    }


    @GetMapping()
    public ResponseEntity<List<TeacherStudent>> listTeacherStudents() {
        List<TeacherStudent> teacherStudents = teacherStudentService.listTeacherStudents();
        return new ResponseEntity<>(teacherStudents, HttpStatus.OK);
    }

    @GetMapping(value = "/search", params = "s_id")
    public ResponseEntity<List<TeacherStudent>> searchTeacherStudentsByStudentId(@RequestParam Long s_id) {
        List<TeacherStudent> teacherStudents = teacherStudentService.getTeacherStudentsByStudentId(s_id);
        return ResponseEntity.ok(teacherStudents);
    }

    @GetMapping(value = "/search", params = "t_id")
    public ResponseEntity<List<TeacherStudent>> searchTeacherStudentsByTeacherId(@RequestParam Long t_id) {
        List<TeacherStudent> teacherStudents = teacherStudentService.getTeacherStudentsByTeacherId(t_id);
        return ResponseEntity.ok(teacherStudents);
    }
}
