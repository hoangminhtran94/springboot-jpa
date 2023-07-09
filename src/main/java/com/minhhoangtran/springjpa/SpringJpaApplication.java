package com.minhhoangtran.springjpa;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.minhhoangtran.springjpa.entity.Student;
import com.minhhoangtran.springjpa.repository.StudentRepository;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student[] students = new Student[] {
				new Student("Hoang Tran", LocalDate.parse(("1980-07-31"))),
				new Student("Linh Lam", LocalDate.parse(("1980-07-31"))),
				new Student("Steven Tran", LocalDate.parse(("1980-07-31"))),
				new Student("Tea Tran", LocalDate.parse(("1980-07-31"))),
		};

		for (int i = 0; i < students.length; i++) {
			studentRepository.save(students[i]);
		}
	}

}
