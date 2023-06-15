package com.antra.hw.repository;

import com.antra.hw.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void addTeacher(){
        Teacher teacher12 = new Teacher("teacher12");
        Teacher save = teacherRepository.save(teacher12);
        System.out.println(save);
    }
}