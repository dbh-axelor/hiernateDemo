package org.example.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "college")
public class College{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collegeId;
	private String collegeName;
	
	@OneToMany(mappedBy = "college")
	private List<Student> students;

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public College(int collegeId, String collegeName, List<Student> students) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.students = students;
	}

	public College() {
	}
	
	
}
