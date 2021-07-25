package com.cm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.model.Course;
import com.cm.repository.ICourseRepository;
import com.cm.service.ICourseService;

@Service
public class CourseServiceImp implements ICourseService {
	
	@Autowired
	private ICourseRepository courseRepository;
	
	@Override
	public List<Course> showCourses() {
		// TODO Auto-generated method stub
		
		return (List<Course>) courseRepository.findAll();
	}

	@Override
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepository.save(course);
		
	}

	@Override
	public Course findCourseById(Long id) {
		// TODO Auto-generated method stub
		
		return courseRepository.findById(id).get();
	}

	@Override
	public List<Course> findCourseByNameAndCiclo(String name,String ciclo) {
		// TODO Auto-generated method stub
		return courseRepository.findByNameAndCiclo(name,ciclo);
	}

	@Override
	public List<Course> findRepeats(String name, String division, String ciclo, String turn) {
		// TODO Auto-generated method stub
		return courseRepository.findByNameAndDivisionAndCicloAndTurn(name, division, ciclo, turn);
	}

	
	

}
