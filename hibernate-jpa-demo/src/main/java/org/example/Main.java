package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.example.entities.Student;

public class Main {
	
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
	
    EntityManager entityManager = entityManagerFactory.createEntityManager();

	
    public static void main(String[] args) {
    	
    	
    	Student student = new Student();
    	student.
    	
    }
}