package com.minhhoangtran.springjpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.minhhoangtran.springjpa.entity.Course;
import com.minhhoangtran.springjpa.entity.Student;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
