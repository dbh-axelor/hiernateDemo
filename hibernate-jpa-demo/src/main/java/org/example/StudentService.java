package org.example;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.checkerframework.checker.interning.qual.FindDistinct;
import org.example.entities.College;
import org.example.entities.Course;
import org.example.entities.Exam;
import org.example.entities.Phone;
import org.example.entities.Student;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryCollectionReturn;

public class StudentService {
	
	public static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Demo-jpa");
	
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	
	
	public static void updateData(int id){
		entityManager.getTransaction().begin();;

		try {
			Student student = entityManager.find(Student.class, id);
			student.setStuddepartment("CE");
			System.out.println("Your data has been updated");
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteData(int id){
		entityManager.getTransaction().begin();;

		try {
			Student student = entityManager.find(Student.class, id);
			entityManager.remove(student);
			System.out.println("Your data has been deleted");
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void showData() {
			try {		
			List<Student> students = entityManager.createQuery("FROM Student",Student.class).getResultList();
			
			for(Student records : students) {
				System.out.println("Student ID : "+records.getStidId());
				System.out.println("Student Name : "+records.getStudName());
				System.out.println("College name: "+records.getCollege().getCollegeName());
			}
	
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void createStudent(String clgname,String studentName,String studentAddr, String studentDepart, long studentPh, String ex1, String ex2, String studentCourse) {
		EntityTransaction tx = entityManager.getTransaction();
	       
		try {
			tx.begin();
			
			// add college
			College clg = new College();
			clg.setCollegeName(clgname);		// college name
			entityManager.persist(clg);

			// add student
			Student student = new Student();
			student.setStudName(studentName); 			// student name
			student.setStudAdd(studentAddr);			// student address
			student.setStuddepartment(studentDepart);	// student department
			
			entityManager.persist(student);
			
			student.setCollege(clg); 
			
			// create phone 
			Phone phone = new Phone();
			phone.setPhNumber(studentPh);				// student phone number
			phone.setStudent(student);
			
			student.setPhone(phone);
			entityManager.persist(phone);
			
			// add exam
			
			Exam exam1 = new Exam();
			exam1.setStudent(student);
			exam1.setSubject(ex1);						// exam name 1
			
			Exam exam2 = new Exam();
			exam2.setStudent(student);
			exam2.setSubject(ex2);						// exam name 2
			
			List<Exam> examList = new ArrayList<Exam>();
			examList.add(exam1);
			examList.add(exam2);
			
			student.setExams(examList);
			
			// add course 
			Course course = new Course();
			course.setCourseName(studentCourse); 	   // course name
			
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
