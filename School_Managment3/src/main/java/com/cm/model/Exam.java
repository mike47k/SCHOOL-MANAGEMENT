package com.cm.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "EXAMS")
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int noteExam;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateExam;
	
	@ManyToOne
	@JoinColumn(name = "FK_NOTE", nullable = false, updatable = false)
	private Note note;

	public Exam(Long id, int noteExam, LocalDate dateExam, Note note) {
		super();
		this.id = id;
		this.noteExam = noteExam;
		this.dateExam = dateExam;
		this.note = note;
	}

	public Exam() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNoteExam() {
		return noteExam;
	}

	public void setNoteExam(int noteExam) {
		this.noteExam = noteExam;
	}

	public LocalDate getDateExam() {
		return dateExam;
	}

	public void setDateExam(LocalDate dateExam) {
		this.dateExam = dateExam;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	

}
