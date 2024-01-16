package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.example.entities.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    private static SessionFactory factory;

    public static void main(String[] args) {
    	  try {
              factory = new Configuration().configure().buildSessionFactory();
          } catch (Throwable ex) {
              System.err.println("Failed to create sessionFactory object." + ex);
              throw new ExceptionInInitializerError(ex);
          }
    	  
    		Main objMain = new Main();
    		
//				Integer data1 = objMain.addEmployee(1,"Raj",10000,"Intern Java Developer");
//				Integer data2 = objMain.addEmployee(2,"Jarvis",50000,"Backend Lead");
//				Integer data3 = objMain.addEmployee(3,"carryminati",20000,"multimedia technition");

//				System.out.println("Before Update");
				objMain.listEmployee();
				
				Integer id = 2;
				String name = "devang";
				Integer salary = 10000;
				String designation = "senior developer";
				
//				objMain.updateEmployee(id,name,salary,designation);
				
//				System.out.println("After Update");
//				objMain.listEmployee();
//				Integer newid = 3;
//				objMain.deleteEmployee(newid);
//				objMain.listEmployee();
				
				
				
    }

	private void updateEmployee(Integer id,String name, Integer salary, String designation) {

		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
	         
			Employee emp = (Employee)session.get(Employee.class, id);
	         
	         emp.setName(name);
	         emp.setSalary(salary);
	         emp.setDesignation(designation);
	         
	         session.update(emp);
	         tx.commit();
	         
		}catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private void deleteEmployee(Integer empID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
	         Employee emp = (Employee)session.get(Employee.class, empID);
	         session.delete(emp);
	         tx.commit();
		}catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	private void listEmployee() {
		Session session = factory.openSession();
        Transaction tx = null;
        
        try {
			
        	tx = session.beginTransaction();
        	
			List employee = session.createQuery("FROM Employee").list();
			
			for (@SuppressWarnings("rawtypes")
			Iterator iterator = employee.iterator(); 
			iterator.hasNext();) {
                Employee emp = (Employee) iterator.next();
                System.out.println("ID: " + emp.getE_id());
                System.out.println("Name: " + emp.getName());
                System.out.println("Salary: " + emp.getSalary());
                System.out.println("Designation: " + emp.getDesignation());
			}
            
        	
		} catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}

	private Integer addEmployee(int id, String name, int salary, String des) {
    	Session session = factory.openSession();
    	Transaction tx = null;
		Integer txID = null;
    	try {
			tx = session.beginTransaction();
			Employee emp = new Employee();
			
			emp.setE_id(id);
			emp.setName(name);
			emp.setSalary(salary);
			emp.setDesignation(des);
			
			session.save(emp);
			System.out.println("Your Data has updated");
			tx.commit();
			
    	} catch (HibernateException e) {
    		if(tx!=null) tx.rollback();
    		e.printStackTrace();
    	}finally {
			session.close();
		}
    	
		return txID;
	}
    	

}