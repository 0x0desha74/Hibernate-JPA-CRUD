package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    //Injecting StudentDAO
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            //createMultipleStudents(studentDAO);
            //readStudent(studentDAO);
            queryForStudent(studentDAO);
        };
    }

    private void queryForStudent(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        for (Student student : students)
            System.out.println(student);
    }

    private void readStudent(StudentDAO studentDAO) {
        Student student =  studentDAO.findById(1);
        System.out.println(student);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        Student student1 = new Student("Mustafa","Elsayed","mustafa.elsayed@gmail.com");
        Student student2 = new Student("Menna","Elsayed","menna.elsayed@gmail.com");
        Student student3 = new Student("Mohamed","Elsayed","mohamed.elsayed@gmail.com");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);


    }


    private void createStudent(StudentDAO studentDAO) {
        //Creating the student object
        System.out.println("Creating new student object...");
        Student student = new Student("Mustafa","Elsayed","mustafa.elsayed@gmail.com");
        //Save student object
        studentDAO.save(student);
        // Display id of the  saved student
        System.out.println(student.getId());
    }
}
