package com.cm.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "SUBJECTS ")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message="Debe ingresar un nombre")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
	private List<Note> note;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
	private List<SubjectCourse> subjectCourse;

	public Subject() {
		super();
	}

	public Subject(long id, String name,  List<Note> note,List<SubjectCourse> subjectCourse) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public int hashCode() {
		return Objects.hash(id, name, note, subjectCourse);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(note, other.note)
				&& Objects.equals(subjectCourse, other.subjectCourse);
	}

	
	
	

}
