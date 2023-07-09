package com.minhhoangtran.springjpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.minhhoangtran.springjpa.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
