package com.eray.rabbitmq.producer;

import com.eray.rabbitmq.producer.domain.Lesson;
import com.eray.rabbitmq.producer.domain.Student;
import com.eray.rabbitmq.producer.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Autowired
	Producer producer;

	@Override
	public void run(String... args) throws Exception {
		Student firstStudent=new Student();
		firstStudent.setName("eray");
		firstStudent.setRoutingKey("eray.students.first");
		List<Lesson> lessons=new ArrayList<>();
		Lesson lesson=new Lesson();
		lesson.setName("maths");
		lessons.add(lesson);

		producer.produce(firstStudent);

		Student secondStudent=new Student();
		secondStudent.setName("john");
		secondStudent.setRoutingKey("eray.students.second");
		Lesson lesson2=new Lesson();
		lesson2.setName("chem");
		lessons.add(lesson2);

		producer.produce(secondStudent);

		Student thirdStudent=new Student();
		thirdStudent.setName("matt");
		thirdStudent.setRoutingKey("eray.test.deneme");
		Lesson lesson3=new Lesson();
		lesson3.setName("bio");
		lessons.add(lesson3);

		producer.produce(thirdStudent);


	}
}

