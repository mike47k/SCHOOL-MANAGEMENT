package com.cm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.model.SubjectCourse;
import com.cm.repository.ISubjectCourseRepository;
import com.cm.service.ISubjectCourseService;

@Service
public class SubjectCourseImp implements ISubjectCourseService{

	@Autowired
	private ISubjectCourseRepository subjectCourseRepository;
	@Override
	public SubjectCourse saveSubjectCourse(SubjectCourse subjectCourse) {
		// TODO Auto-generated method stub
		return subjectCourseRepository.save(subjectCourse);
	}
	@Override
	public List<SubjectCourse> getSubjectCourseByCourseId(Long id) {
		// TODO Auto-generated method stub
		return subjectCourseRepository.findByCourseId(id);
	}
	@Override
	public List<SubjectCourse> getSubjectCourseBySubjectId(Long id) {
		// TODO Auto-generated method stub
		return subjectCourseRepository.findBySubjectId(id);
	}
	@Override
	public List<SubjectCourse> saveSubjectCourseList(List<SubjectCourse> subjectCourses) {
		// TODO Auto-generated method stub
		return (List<SubjectCourse>) subjectCourseRepository.saveAll(subjectCourses);
	}

}
