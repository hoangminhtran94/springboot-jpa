package com.minhhoangtran.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minhhoangtran.springjpa.entity.Grade;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeService gradeService;

    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGrade'");
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveGrade'");
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateGrade'");
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
