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
@Table(name = "SUBJECTCOURSE")
public class SubjectCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "FK_SUBJECT", nullable = false, updatable = false)
	private Subject subject;
	
	@ManyToOne
	@JoinColumn(name = "FK_COURSE", nullable = false, updatable = false)
	private Course course;
	
	
	public SubjectCourse() {
		super();
	}


	public SubjectCourse(Long id, Subject subject, Course course) {
		super();
		this.id = id;
		this.subject = subject;
		this.course = course;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Subject getSubject() {
		return subject;
	}


	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}
	
	

}
