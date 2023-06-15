package com.antra.hw.service;


import com.antra.hw.model.Student;
import com.antra.hw.model.TeacherStudent;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student addStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);

    Optional<Student> getStudentById(Long id);

    List<Student> listStudents();

}
