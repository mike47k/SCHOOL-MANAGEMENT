package com.cm.model;

import java.time.LocalDate;
import java.util.Date;
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
@Table(name = "NOTES")
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int note1;
	private int note2;
	private int note3;
	private int average;
	private int fNote;
	private String status;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "note")
	private List<Exam> exam;
	
	@ManyToOne
	@JoinColumn(name = "FK_SUBJECT", nullable = false, updatable = false)
	private Subject subject;
	
	@ManyToOne
	@JoinColumn(name = "FK_STUDENT", nullable = false, updatable = false)
	private Student student;

	public Note() {
		super();
	}

	public Note(Long id, int note1, int note2, int note3, int average, Subject subject,
			Student student,int fNote,List<Exam> exam,String status) {
		super();
		this.id = id;
		this.note1 = note1;
		this.note2 = note2;
		this.note3 = note3;
		this.average = average;
		this.subject = subject;
		this.student = student;
		this.fNote = fNote;
		this.exam = exam;
		this.status = status;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNote1() {
		return note1;
	}

	public void setNote1(int note1) {
		this.note1 = note1;
	}

	public int getNote2() {
		return note2;
	}

	public void setNote2(int note2) {
		this.note2 = note2;
	}

	public int getNote3() {
		return note3;
	}

	public void setNote3(int note3) {
		this.note3 = note3;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	


	public int getfNote() {
		return fNote;
	}

	public void setfNote(int fNote) {
		this.fNote = fNote;
	}
	
	



	

	public List<Exam> getExam() {
		return exam;
	}

	public void setExam(List<Exam> exam) {
		this.exam = exam;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", note1=" + note1 + ", note2=" + note2 + ", note3=" + note3 + ", average=" + average
				+ ", subject=" + subject + ", student=" + student + "]";
	}

	
	
	

}
