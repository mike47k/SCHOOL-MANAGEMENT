package com.cm.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Form {

	private Subject subject;
	private Student student;
	private CoursePeriod coursePeriod;
	private int year;
	private String name;
	private List<Note> notes;
	private Course course;
	private Long aux;
	private SubjectCourse subjectCourse;
	private List<Course> courseList;
	private Exam exam;
	
	
	
	public Form() {
		super();
	}



	public Form(Subject subject, Student student, CoursePeriod coursePeriod, int year,
			List<Note> notes,Course course,Long aux,SubjectCourse subjectCourse,List<Course> courseList,
			Exam exam,String name) {
		super();
		this.subject = subject;
		this.student = student;
		this.coursePeriod = coursePeriod;
		this.year = year;
		this.notes = notes;
		this.course = course;
		this.aux = aux;
		this.subjectCourse = subjectCourse;
		this.courseList = courseList;
		this.exam = exam;
		this.name = name;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
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



	public CoursePeriod getCoursePeriod() {
		return coursePeriod;
	}



	public void setCoursePeriod(CoursePeriod coursePeriod) {
		this.coursePeriod = coursePeriod;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}
	
	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	public void addNote(Note note) {
		this.notes.add(note);
	}



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	public Long getAux() {
		return aux;
	}



	public void setAux(Long aux) {
		this.aux = aux;
	}



	public SubjectCourse getSubjectCourse() {
		return subjectCourse;
	}



	public void setSubjectCourse(SubjectCourse subjectCourse) {
		this.subjectCourse = subjectCourse;
	}



	public List<Course> getCourseList() {
		return courseList;
	}



	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}



	public Exam getExam() {
		return exam;
	}



	public void setExam(Exam exam) {
		this.exam = exam;
	}

	
	
	
	
}
