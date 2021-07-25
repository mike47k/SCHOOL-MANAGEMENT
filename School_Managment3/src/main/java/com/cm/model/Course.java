package com.cm.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "COURSES")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;

	private String division;

	private String ciclo;

	private String turn;
		
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
	private List<CoursePeriod> coursePeriod;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
	private List<SubjectCourse> subjectCourse;
	
	public Course() {
		super();
	}

	public Course(long id, String name, String division, String turn, List<CoursePeriod> coursePeriod,String ciclo,List<SubjectCourse> subjectCourse) {
		super();
		this.id = id;
		this.name = name;
		this.division = division;
		this.turn = turn;
		this.coursePeriod = coursePeriod;
		this.ciclo = ciclo;
		this.subjectCourse = subjectCourse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	public List<CoursePeriod> getCoursePeriod() {
		return coursePeriod;
	}

	public void setCoursePeriod(List<CoursePeriod> coursePeriod) {
		this.coursePeriod = coursePeriod;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public List<SubjectCourse> getSubjectCourse() {
		return subjectCourse;
	}

	public void setSubjectCourse(List<SubjectCourse> subjectCourse) {
		this.subjectCourse = subjectCourse;
	}



	
	
	
	
	

}
