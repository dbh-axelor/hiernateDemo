package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import org.example.entities.College;
import org.example.entities.Course;
import org.example.entities.Exam;
import org.example.entities.Phone;
import org.example.entities.Student;

import org.example.StudentService;


public class Main {
	
	

    private StudentService studentService = new StudentService();
    
    public static void main(String[] args) {
    	
    	String clgname = "VNSGU";
    	String studentName = "Dishant";
    	String studentAddr = "Surat";
    	String studentDepart = "IT";
    	long studentPh = 1111122222;
    	String ex1 = "java";
    	String ex2 = "Web Development";
    	String studentCourse = "java Backend Developer";
    	
    	System.out.println("sucesss ----------------->>>>>>>>>> ");
//    	StudentService.createStudent(clgname,studentName,studentAddr, studentDepart,studentPh, ex1, ex2, studentCourse);

    	StudentService.showData();

    }



}