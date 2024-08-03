package com.database_project1.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.database_project1.demo.jdbc.Student;
import com.database_project1.demo.service.StudentService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		Student s1 = context.getBean(Student.class);
		s1.setMarks(85);
		s1.setName("Gaurav Kumar");
		s1.setrollno(20032);

		StudentService ser = context.getBean(StudentService.class);
		ser.addrow(s1);
	}

}
