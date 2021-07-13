package com.cm.service;

import java.util.List;

import com.cm.model.SubjectCourse;

public interface ISubjectCourseService {
	
	public SubjectCourse saveSubjectCourse(SubjectCourse subjectCourse);
	
	public List<SubjectCourse> getSubjectCourseByCourseId(Long id);

	public List<SubjectCourse> getSubjectCourseBySubjectId(Long id);
	
	public List<SubjectCourse> saveSubjectCourseList(List<SubjectCourse> subjectCourses);
}
