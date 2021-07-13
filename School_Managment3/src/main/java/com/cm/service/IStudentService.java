package com.cm.service;

import java.util.List;

import com.cm.model.Student;
import com.cm.model.Subject;

public interface IStudentService {

	public Student saveStudent(Student student);
	
	public List<Student> getStudents();
	
	public Student getStudentById(Long id);
	
	public List<Student> showStudentFind(Long dni,String name,String surname,int edad,String status);
}
