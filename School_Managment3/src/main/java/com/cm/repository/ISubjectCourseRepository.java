package com.cm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cm.model.SubjectCourse;

public interface ISubjectCourseRepository extends CrudRepository<SubjectCourse, Long>{
	
	List<SubjectCourse> findByCourseId(Long id);
	List<SubjectCourse> findBySubjectId(Long id);

}
