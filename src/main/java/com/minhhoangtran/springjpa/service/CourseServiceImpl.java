package com.minhhoangtran.springjpa.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minhhoangtran.springjpa.entity.Course;
import com.minhhoangtran.springjpa.entity.Grade;
import com.minhhoangtran.springjpa.entity.Student;
import com.minhhoangtran.springjpa.exception.CourseNotFoundException;
import com.minhhoangtran.springjpa.exception.GradeNotFoundException;
import com.minhhoangtran.springjpa.exception.StudentNotFoundException;
import com.minhhoangtran.springjpa.repository.CourseRepository;
import com.minhhoangtran.springjpa.repository.StudentRepository;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Course getCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return unwrapCourse(course, id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public static Course unwrapCourse(Optional<Course> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new CourseNotFoundException(id);
    }

    static Grade unwrapGrade(Optional<Grade> entity, Long studentId, Long courseId) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new GradeNotFoundException(studentId, courseId);
    }

    public static Student unwrapStudent(Optional<Student> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new StudentNotFoundException(id);
    }

    @Override
    public Course addStudentToCourse(Long studentId, Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        Course unwrappedCourse = unwrapCourse(course, courseId);
        Optional<Student> student = studentRepository.findById(studentId);
        Student unwrappedStudent = unwrapStudent(student, courseId);
        unwrappedCourse.getStudents().add(unwrappedStudent);
        return courseRepository.save(unwrappedCourse);
    }

    @Override
    public Set<Student> getEnrolledStudents(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        Course unwrappedCourse = unwrapCourse(course, id);
        return unwrappedCourse.getStudents();
    }

}
