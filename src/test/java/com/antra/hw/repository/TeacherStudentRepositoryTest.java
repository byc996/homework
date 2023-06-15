package com.antra.hw.repository;

import com.antra.hw.model.Student;
import com.antra.hw.model.Teacher;
import com.antra.hw.model.TeacherStudent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherStudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherStudentRepository teacherStudentRepository;
    @Test
    public void testAddTeacherStudent() {
        Student stu10 = studentRepository.findById(5L).get();
        Teacher teacher10 = teacherRepository.findById(2L).get();
        TeacherStudent teacherStudent = teacherStudentRepository.save(new TeacherStudent(stu10, teacher10));
        System.out.println(teacherStudent);
    }

    @Test
    public void testFindTeacherStudentsByStudentId() {
        List<TeacherStudent> teacherStudents = teacherStudentRepository.findTeacherStudentsByStudentId(1L);
        System.out.println(teacherStudents);
    }

    @Test
    public void testGetTeacherStudentsById() {
        TeacherStudent teacherStudents = teacherStudentRepository.findById(1L).get();
        System.out.println(teacherStudents);
    }

}