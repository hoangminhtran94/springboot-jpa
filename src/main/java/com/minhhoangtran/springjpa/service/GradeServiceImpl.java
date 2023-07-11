package com.minhhoangtran.springjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.minhhoangtran.springjpa.entity.Course;
import com.minhhoangtran.springjpa.entity.Grade;
import com.minhhoangtran.springjpa.entity.Student;
import com.minhhoangtran.springjpa.repository.CourseRepository;
import com.minhhoangtran.springjpa.repository.GradeRepository;
import com.minhhoangtran.springjpa.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GradeServiceImpl implements GradeService {

    GradeRepository gradeRepository;
    StudentRepository studentRepository;
    CourseRepository courseRepository;

    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        return gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).get();
        Course course = courseRepository.findById(courseId).get();
        grade.setStudent(student);
        grade.setCourse(course);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Grade grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        grade.setScore(score);
        return gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteGrade'");
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudentGrades'");
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCourseGrades'");
    }

    @Override
    public List<Grade> getAllGrades() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllGrades'");
    }

}
