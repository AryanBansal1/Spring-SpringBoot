package com.db_prj_2.prj2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.db_prj_2.prj2.db.Student;
import com.db_prj_2.prj2.service.processor;

@SpringBootApplication
public class Prj2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Prj2Application.class, args);
		Student s1 =context.getBean(Student.class);
		processor p1 = context.getBean(processor.class);
		s1.setrollno(20085);
		s1.setName("Aryan Bansal");
		s1.setMarks(94);
		p1.save(s1);

	}

}
