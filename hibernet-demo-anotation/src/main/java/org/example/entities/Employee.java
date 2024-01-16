package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "employee")
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer e_id;
	
	private String name;
	
	private Integer salary;
	
	private String designation;
	
	public Integer getE_id() {
		return e_id;
	}
	public void setE_id(Integer e_id) {
		this.e_id = e_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	public Employee(Integer e_id, String name, Integer salary, String designation) {
		super();
		this.e_id = e_id;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}
	
	public Employee() {
	}
	
	
	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", name=" + name + ", salary=" + salary + ", designation=" + designation
				+ "]";
	}

	
	
}

