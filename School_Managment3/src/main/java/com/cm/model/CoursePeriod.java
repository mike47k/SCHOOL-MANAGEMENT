package com.cm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "COURSEPeriods")
public class CoursePeriod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int period;
	
	
	private int promPeriod;
	
	@ManyToOne
	@JoinColumn(name = "FK_COURSE", nullable = false, updatable = false)
	private Course course;
	
	@ManyToOne
	@JoinColumn(name = "FK_STUDENT", nullable = false, updatable = false)
	private Student student;

	public CoursePeriod() {
		super();
	}

	public CoursePeriod(Long id, int period, Course course, Student student,int promPeriod) {
		super();
		this.id = id;
		this.period = period;
		this.course = course;
		this.student = student;
		this.promPeriod = promPeriod;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getPromPeriod() {
		return promPeriod;
	}

	public void setPromPeriod(int promPeriod) {
		this.promPeriod = promPeriod;
	}
	
	

}
