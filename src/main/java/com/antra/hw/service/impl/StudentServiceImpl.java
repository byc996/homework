package com.antra.hw.service.impl;


import com.antra.hw.model.Student;
import com.antra.hw.model.TeacherStudent;
import com.antra.hw.repository.StudentRepository;
import com.antra.hw.repository.TeacherRepository;
import com.antra.hw.repository.TeacherStudentRepository;
import com.antra.hw.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final TeacherStudentRepository teacherStudentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, TeacherStudentRepository teacherStudentRepository) {
        this.studentRepository = studentRepository;
        this.teacherStudentRepository = teacherStudentRepository;
    }
    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> listStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<TeacherStudent> getTeacherStudentsByStudentId(Long id) {
        return teacherStudentRepository.findTeacherStudentsByStudentId(id);
    }
}
