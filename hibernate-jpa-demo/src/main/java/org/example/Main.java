package org.example;

import org.example.entities.Student;

public class Main {
	
    public static void main(String[] args) {
    	
    	String clgname = "VNSGU";
    	String studentName = "Dishant";
    	String studentAddr = "Surat";
    	String studentDepart = "IT";
    	long studentPh = 1111122222;
    	String ex1 = "java";
    	String ex2 = "Web Development";
    	String studentCourse = "java Backend Developer";
    	
//    	StudentService.createStudent(clgname,studentName,studentAddr, studentDepart,studentPh, ex1, ex2, studentCourse);

    	
//    	StudentService.showData();

    	int id = 4; 	// update by record id
//    	StudentService.updateData(id);
    	
    	
    	//delete record by id
    	StudentService.deleteData(id);

    	
    	StudentService.showData();
    	
    }



}