package com.minhhoangtran.springjpa.exception;

public class StudentNotEnrolledException extends RuntimeException {
    public StudentNotEnrolledException(Long studentId, Long courseId) {
        super("The student with id: '" + studentId + "' have not enrolled in the course id: '" + courseId);
    }
}
