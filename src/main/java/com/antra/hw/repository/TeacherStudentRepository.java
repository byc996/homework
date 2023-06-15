package com.antra.hw.repository;

import com.antra.hw.model.Student;
import com.antra.hw.model.TeacherStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherStudentRepository extends JpaRepository<TeacherStudent, Long> {


    List<TeacherStudent> findTeacherStudentsByStudentId(Long id);

//    @Query(nativeQuery = true, value = "select * from teacher_student where s_id = :student_id")
//    List<TeacherStudent> findBySID(@Param("student_id") Long id);
}
