package com.antra.hw.repository;

import com.antra.hw.model.Student;
import com.antra.hw.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
