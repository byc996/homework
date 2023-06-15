package com.antra.hw.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "teacher_student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherStudent{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "s_id")
//    @JsonIgnoreProperties(value = { "teacherStudents"})
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_id")
//    @JsonIgnoreProperties(value = { "teacherStudents"})
    private Teacher teacher;


    public TeacherStudent(Student student, Teacher teacher) {
        this(null, student, teacher);
    }

    @Override
    public String toString() {
        return "TeacherStudent{" +
                "id=" + id +
                ", s_id=" + student.getId() +
                ", t_id=" + teacher.getId() +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherStudent that = (TeacherStudent) o;
        return Objects.equals(id, that.id) && Objects.equals(student, that.student) && Objects.equals(teacher, that.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, teacher);
    }
}
