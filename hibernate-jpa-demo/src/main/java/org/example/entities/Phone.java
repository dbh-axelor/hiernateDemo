package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int phId;
	private long phNumber;
	
	@OneToOne(mappedBy = "phone")
	private Student student;

	public int getPhId() {
		return phId;
	}

	public void setPhId(int phId) {
		this.phId = phId;
	}

	public long getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(long phNumber) {
		this.phNumber = phNumber;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Phone(int phId, long phNumber, Student student) {
		super();
		this.phId = phId;
		this.phNumber = phNumber;
		this.student = student;
	}

	public Phone() {
		
	}

	
	
}
