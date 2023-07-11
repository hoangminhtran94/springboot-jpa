package com.minhhoangtran.springjpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.minhhoangtran.springjpa.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
