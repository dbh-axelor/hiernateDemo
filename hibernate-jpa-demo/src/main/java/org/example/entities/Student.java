package org.example.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studId;
	private String studName;
	private String studAdd;
	private String Studdepartment;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<Exam> exams;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "phone_id")
	private Phone phone;
	
	@ManyToOne
	@JoinColumn(name = "college_id")
	private College college;
	
	@ManyToMany
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;

	public int getStidId() {
		return studId;
	}

	public void setStidId(int stidId) {
		this.studId = stidId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getStudAdd() {
		return studAdd;
	}

	public void setStudAdd(String studAdd) {
		this.studAdd = studAdd;
	}

	public String getStuddepartment() {
		return Studdepartment;
	}

	public void setStuddepartment(String studdepartment) {
		Studdepartment = studdepartment;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Student(int studId, String studName, String studAdd, String studdepartment, List<Exam> exams, Phone phone,
			College college, List<Course> courses) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studAdd = studAdd;
		Studdepartment = studdepartment;
		this.exams = exams;
		this.phone = phone;
		this.college = college;
		this.courses = courses;
	}

	public Student() {
	}
	
}
