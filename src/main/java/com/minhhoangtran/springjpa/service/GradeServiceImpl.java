package com.minhhoangtran.springjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.minhhoangtran.springjpa.entity.Course;
import com.minhhoangtran.springjpa.entity.Grade;
import com.minhhoangtran.springjpa.entity.Student;
import com.minhhoangtran.springjpa.exception.CourseNotFoundException;
import com.minhhoangtran.springjpa.exception.GradeNotFoundException;
import com.minhhoangtran.springjpa.exception.StudentNotEnrolledException;
import com.minhhoangtran.springjpa.exception.StudentNotFoundException;
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
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        if (grade.isPresent()) {
            return grade.get();
        } else {
            throw new GradeNotFoundException(studentId, courseId);
        }

    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).get();
        Course course = courseRepository.findById(courseId).get();
        if (student == null) {
            throw new StudentNotFoundException(studentId);
        }
        if (course == null) {
            throw new CourseNotFoundException(courseId);
        }
        if (!student.getCourses().contains(course))
            throw new StudentNotEnrolledException(studentId, courseId);
        grade.setCourse(course);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        if (grade.isPresent()) {
            Grade updatingGrade = grade.get();
            updatingGrade.setScore(score);
            return gradeRepository.save(updatingGrade);

        } else {
            throw new GradeNotFoundException(studentId, courseId);
        }
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }

}
