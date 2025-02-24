package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO,13);
			//queryForStudents(studentDAO);
			//queryForStudents(studentDAO,"Bottle");
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}
	private void createStudent(StudentDAO studentDAO){
		System.out.println("Creating new Student");
		Student theStudent=new Student("Ana", "Kutsia","akutsia@bog.ge");

		System.out.println("Created student. saving to database...");
		studentDAO.save(theStudent);

		System.out.println("Generated student ID: "+theStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO){
		System.out.println("Creating new Students");
		Student theStudent1=new Student("Ana", "Kutsia","akutsia@bog.ge");
		Student theStudent2=new Student("Ana", "Kutsia","akutsia@bog.ge");
		Student theStudent3=new Student("Ana", "Kutsia","akutsia@bog.ge");

		System.out.println("Created students. saving to database...");
		studentDAO.save(theStudent1);
		studentDAO.save(theStudent2);
		studentDAO.save(theStudent3);


		System.out.println("Generated student ID: "+theStudent1.getId());
		System.out.println("Generated student ID: "+theStudent2.getId());
		System.out.println("Generated student ID: "+theStudent3.getId());
	}

	private void readStudent(StudentDAO studentDAO, Integer id){
		Student student=studentDAO.findById(id);
		System.out.println(student);
	}

	private void queryForStudents(StudentDAO studentDAO){
		List<Student> studentsResultList=studentDAO.findAll();
		for(Student currStudent : studentsResultList){
			System.out.println(currStudent);
		}
	}
	private void queryForStudents(StudentDAO studentDAO, String lastName){
		List<Student> studentsResultList=studentDAO.findByLastName(lastName);
		for(Student currStudent : studentsResultList){
			System.out.println(currStudent);
		}
	}

	private void updateStudent(StudentDAO studentDAO){
		int studentId=1;
		//retrieve student based on the id
		Student student=studentDAO.findById(1);
		//change first name to "Scooby"
		student.setFirstName("Luka");

		//update the student
		studentDAO.update(student);

		//display the updated student
		System.out.println(student);
	}
	private void deleteStudent(StudentDAO studentDAO){
		int studentId=7;
		System.out.println("Deleting student id: "+studentId);
		studentDAO.delete(7);
	}

	private void deleteAllStudents(StudentDAO studentDAO){
		System.out.println("Deleting all the records from student table");
		System.out.println("Deleted "+studentDAO.deleteAll() + " rows");
	}

}
