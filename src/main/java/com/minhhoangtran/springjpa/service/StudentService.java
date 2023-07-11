package com.minhhoangtran.springjpa.service;

import java.util.List;
import java.util.Set;

import com.minhhoangtran.springjpa.entity.Course;
import com.minhhoangtran.springjpa.entity.Student;

public interface StudentService {
    Student getStudent(Long id);

    Student saveStudent(Student student);

    void deleteStudent(Long id);

    List<Student> getStudents();

    Set<Course> getEnrolledCourses(Long id);
}
