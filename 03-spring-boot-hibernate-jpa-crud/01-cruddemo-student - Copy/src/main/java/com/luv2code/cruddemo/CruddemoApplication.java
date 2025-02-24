package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
			//readStudent(studentDAO,14);
			//queryStudents(studentDAO,"tokhvadze");
			//queryStudents(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteAllStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO){
		Student theStudent= new Student("Tinatin", "Tokhvadze","ttokhvadze@bog.ge");
		System.out.println("Inserting student: "+theStudent);
		studentDAO.save(theStudent);
	}

	private void readStudent(StudentDAO studentDAO, Integer id){
		Student student=studentDAO.findById(id);
		System.out.println(student);
	}

	private void queryStudents(StudentDAO studentDAO, String lastName){
		List<Student> studentList=studentDAO.findByLastName(lastName);
		for(Student currStudent : studentList){
			System.out.println(currStudent);
		}
	}
	private void queryStudents(StudentDAO studentDAO){
		List<Student> studentList=studentDAO.findAll();
		for(Student currStudent : studentList){
			System.out.println(currStudent);
		}
	}

	private void updateStudent(StudentDAO studentDAO){
		int id=13;
		Student studentToUpdate=studentDAO.findById(id);
		System.out.println("Before update: ");
		System.out.println(studentToUpdate);
		studentToUpdate.setFirstName("Levan");
		studentToUpdate.setEmail("ltokhvadze@bog.ge");

		studentDAO.update(studentToUpdate);
		System.out.println("After update: ");
		System.out.println(studentToUpdate);
	}

	private void deleteStudent(StudentDAO studentDAO){
		studentDAO.delete(12);
		System.out.println("Deleted successfully");
	}
	private void deleteAllStudent(StudentDAO studentDAO){
		int totalDeletedRowNum=studentDAO.deleteAll();
		System.out.println("Deleted "+totalDeletedRowNum + " rows");
	}

}