package com.cm.service;

import java.util.List;

import com.cm.model.Course;

public interface ICourseService {
	
	public void saveCourse(Course course);

	public List<Course> showCourses();
	
	public Course findCourseById(Long id);
	
	public List<Course> findCourseByNameAndCiclo(String name,String ciclo);
}
