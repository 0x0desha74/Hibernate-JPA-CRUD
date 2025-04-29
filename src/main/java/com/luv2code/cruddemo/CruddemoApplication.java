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
            // createMultipleStudents(studentDAO);
            // readStudent(studentDAO);
            //queryForStudents(studentDAO);
        // filterByLastName(studentDAO,"ahmed");
            // updateStudent(studentDAO);
            // deleteSrudent(studentDAO);
        deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
    studentDAO.deleteAll();
    }

    private void deleteSrudent(StudentDAO studentDAO) {
        int id =4;
        studentDAO.deleteStudent(id);
        System.out.printf("Student with id = %d has been successfully deleted.",id);
    }

    private void updateStudent(StudentDAO studentDAO) {
        var student = studentDAO.findById(1);
        student.setFirstName("mustafa");
        student.setLastName("elsayed");
        student.setEmail("mustafa@gmail.com");
        studentDAO.updateStudent(student);
    }

    private void filterByLastName(StudentDAO studentDAO, String name) {
    List<Student> students =  studentDAO.findByLastName(name);
    for(var student : students)
        System.out.println(student);
    }

    private void queryForStudents(StudentDAO studentDAO) {
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
        Student student = new Student("Ziad","Ahmed","ziad.ahmed@gmail.com");
        //Save student object
        studentDAO.save(student);
        // Display id of the  saved student
        System.out.println(student.getId());
    }
}
