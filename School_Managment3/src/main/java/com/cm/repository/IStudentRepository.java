package com.cm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cm.model.Student;

public interface IStudentRepository extends CrudRepository<Student, Long> {
	
	List<Student> findByDni(Long dni);
	List<Student> findByName(String name);
	List<Student> findBySurname(String surname);
	List<Student> findByAgeGreaterThanEqual(int age);
	List<Student> findByStatus(String status);
	List<Student> findByNameAndSurnameAndAgeGreaterThanEqualAndStatus(String name,String surname,int age,String status);
	List<Student> findByNameAndAgeGreaterThanEqual(String name,int age);
	List<Student> findBySurnameAndAgeGreaterThanEqual(String name,int age);
	List<Student> findByStatusAndAgeGreaterThanEqual(String name,int age);
}
