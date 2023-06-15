package com.antra.hw.service.impl;


import com.antra.hw.model.Teacher;
import com.antra.hw.model.TeacherStudent;
import com.antra.hw.repository.TeacherRepository;
import com.antra.hw.repository.TeacherStudentRepository;
import com.antra.hw.service.TeacherStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherStudentServiceImpl implements TeacherStudentService {

    private final TeacherStudentRepository teacherStudentRepository;

    @Autowired
    public TeacherStudentServiceImpl(TeacherStudentRepository teacherStudentRepository) {
        this.teacherStudentRepository = teacherStudentRepository;
    }

    @Override
    public List<TeacherStudent> listTeacherStudents() {
        return teacherStudentRepository.findAll();
    }
}
