package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int exId;
	private String subject;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public int getExId() {
		return exId;
	}

	public void setExId(int exId) {
		this.exId = exId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Exam(int exId, String subject, Student student) {
		super();
		this.exId = exId;
		this.subject = subject;
		this.student = student;
	}

	public Exam() {
	}
	
	
}
