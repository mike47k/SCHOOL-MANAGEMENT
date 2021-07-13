package com.cm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cm.model.Course;

public interface ICourseRepository extends CrudRepository<Course, Long> {
	
	List<Course> findByNameAndCiclo(String name,String ciclo);

}
