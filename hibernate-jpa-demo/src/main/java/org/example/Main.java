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
	
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Demo-jpa");
	
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    private StudentService studentService = new StudentService();
    
    public static void main(String[] args) {
    	
    	
    	System.out.println("sucesss ----------------->>>>>>>>>> ");
    	
    	StudentService.hello("devang");

    	Main objMain = new Main();
    	
//    	objMain.createStudent();
    	
    	objMain.showStudent();

    }


	private void showStudent() {
		try {		
			List<Student> students = entityManager.createQuery("FROM Student",Student.class).getResultList();
			

			
			for(Student records : students) {
				System.out.println(records.getStidId());
				System.out.println(records.getStudName());
				
			}
			
	
			entityManager.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}


	private void createStudent() {
        EntityTransaction tx = entityManager.getTransaction();
       
		try {
			tx.begin();
			
			// add college
	      
			College clg = new College();
			clg.setCollegeName("utu");
			
			entityManager.persist(clg);

			
			
			// add student
			
			Student student = new Student();
//			student.setStudId(1);
			student.setStudName("devang");
			student.setStudAdd("surat");
			student.setStuddepartment("IT");
			
			entityManager.persist(student);
			
			student.setCollege(clg); 
			
			// create phone 
			Phone phone = new Phone();
			phone.setPhNumber(1111222333);
			phone.setStudent(student);
			
			student.setPhone(phone);
			entityManager.persist(phone);
			
			// add exam
			
			Exam exam1 = new Exam();
			exam1.setStudent(student);
			exam1.setSubject("java");
			
			Exam exam2 = new Exam();
			exam2.setStudent(student);
			exam2.setSubject("python");
			
			List<Exam> examList = new ArrayList<Exam>();
			examList.add(exam1);
			examList.add(exam2);
			
			student.setExams(examList);
			
			// add course 
			
			Course course = new Course();
			course.setCourseName("Java Backend Developer");
			
			List<Course> courseList = new ArrayList<Course>();
			courseList.add(course);
			
			List<Student> studentList = new ArrayList<Student>();
			studentList.add(student);
			
			clg.setStudents(studentList);
			
			student.setCourses(courseList);

			course.setStudents(studentList);
			
			
			entityManager.persist(course);
			


			

			
			
			
			tx.commit();
		} catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}