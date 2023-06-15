package com.antra.hw.service;


import com.antra.hw.model.Teacher;
import com.antra.hw.model.TeacherStudent;

import java.util.List;

public interface TeacherStudentService {


    List<TeacherStudent> listTeacherStudents();

    List<TeacherStudent> getTeacherStudentsByStudentId(Long s_id);

    List<TeacherStudent> getTeacherStudentsByTeacherId(Long t_id);
}
