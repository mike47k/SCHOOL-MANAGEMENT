package com.cm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "SUBJECTS ")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String turn;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
	private List<Note> note;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
	private List<SubjectCourse> subjectCourse;

	public Subject() {
		super();
	}

	public Subject(long id, String name, String turn,  List<Note> note,List<SubjectCourse> subjectCourse) {
		super();
		this.id = id;
		this.name = name;
		this.turn = turn;
		this.note = note;
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

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	

	public List<Note> getNote() {
		return note;
	}

	public void setNote(List<Note> note) {
		this.note = note;
	}

	public List<SubjectCourse> getSubjectCourse() {
		return subjectCourse;
	}

	public void setSubjectCourse(List<SubjectCourse> subjectCourse) {
		this.subjectCourse = subjectCourse;
	}

	
	
	

}
