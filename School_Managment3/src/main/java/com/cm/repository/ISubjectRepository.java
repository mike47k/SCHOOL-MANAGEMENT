package com.cm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cm.model.Subject;

public interface ISubjectRepository extends CrudRepository<Subject, Long>{

	List<Subject> findByNameContaining(String name);
	List<Subject> findBySubjectCourseCourseName(String name);
	List<Subject> findBySubjectCourseCourseCiclo(String ciclo);
	List<Subject> findByNameContainingAndSubjectCourseCourseNameAndSubjectCourseCourseCiclo(String nameS,String nameC,String ciclo);
	List<Subject> findByNameContainingAndSubjectCourseCourseName(String nameS,String nameC);
	List<Subject> findByNameContainingAndSubjectCourseCourseCiclo(String name,String ciclo);
	List<Subject> findBySubjectCourseCourseNameAndSubjectCourseCourseCiclo(String name,String ciclo);
	
}
