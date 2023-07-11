package com.minhhoangtran.springjpa.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minhhoangtran.springjpa.entity.Course;
import com.minhhoangtran.springjpa.entity.Student;
import com.minhhoangtran.springjpa.exception.StudentNotFoundException;
import com.minhhoangtran.springjpa.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return unwrapStudent(student, id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public static Student unwrapStudent(Optional<Student> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new StudentNotFoundException(id);
    }

    @Override
    public Set<Course> getEnrolledCourses(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return unwrapStudent(student, id).getCourses();
    }

}
