package com.cm.model;

import java.time.LocalDate;
import java.time.Period;
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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name = "STUDENTS")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String surname;
	private long dni;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfInscription;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate lastDateOfReinscription;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfRecived;
	
	private String status;
	
	private String observacion;
	
	private String address;
	
	private int age;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<CoursePeriod> coursePeriod;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<Note> note;
	
	

	public Student() {
		super();
	}



	public Student(long id, String name, String surname, long dni, LocalDate dateOfBirth, LocalDate dateOfInscription,
			LocalDate lastDateOfReinscription, LocalDate dateOfRecived, String status, String address,
			List<CoursePeriod> coursePeriod, List<Note> note,String observacion,int age) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.dateOfBirth = dateOfBirth;
		this.dateOfInscription = dateOfInscription;
		this.lastDateOfReinscription = lastDateOfReinscription;
		this.dateOfRecived = dateOfRecived;
		this.status = status;
		this.address = address;
		this.coursePeriod = coursePeriod;
		this.note = note;
		this.observacion = observacion;
		this.age = age;
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



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public long getDni() {
		return dni;
	}



	public void setDni(long dni) {
		this.dni = dni;
	}



	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		this.age=Period.between(this.dateOfBirth, LocalDate.now()).getYears();
	}



	public LocalDate getDateOfInscription() {
		return dateOfInscription;
	}



	public void setDateOfInscription(LocalDate dateOfInscription) {
		this.dateOfInscription = dateOfInscription;
	}



	public LocalDate getLastDateOfReinscription() {
		return lastDateOfReinscription;
	}



	public void setLastDateOfReinscription(LocalDate lastDateOfReinscription) {
		this.lastDateOfReinscription = lastDateOfReinscription;
	}



	public LocalDate getDateOfRecived() {
		return dateOfRecived;
	}



	public void setDateOfRecived(LocalDate dateOfRecived) {
		this.dateOfRecived = dateOfRecived;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public List<CoursePeriod> getCoursePeriod() {
		return coursePeriod;
	}



	public void setCoursePeriod(List<CoursePeriod> coursePeriod) {
		this.coursePeriod = coursePeriod;
	}



	public List<Note> getNote() {
		return note;
	}



	public void setNote(List<Note> note) {
		this.note = note;
	}



	public String getObservacion() {
		return observacion;
	}



	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}



	public int getAge() {
		return age;
	}



	
	

}
