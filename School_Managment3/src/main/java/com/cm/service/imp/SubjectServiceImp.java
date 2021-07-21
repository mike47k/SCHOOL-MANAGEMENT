package com.cm.service.imp;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.model.Form;
import com.cm.model.Subject;
import com.cm.repository.ISubjectRepository;
import com.cm.service.ISubjectService;
@Service
public class SubjectServiceImp implements ISubjectService{
	
	@Autowired
	private ISubjectRepository subjectRepository;
	@Override
	public Subject saveSubject(Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepository.save(subject);
	}
	@Override
	public List<Subject> showSubjects() {
		// TODO Auto-generated method stub
		return (List<Subject>) subjectRepository.findAll();
	}
	@Override
	public Subject getSubjectById(Long id) {
		// TODO Auto-generated method stub
		return subjectRepository.findById(id).get();
	}
	@Override
	public List<Subject> getSubjectsByName(String name) {
		// TODO Auto-generated method stub
		return subjectRepository.findByNameContaining(name);
	}
	@Override
	public List<Subject> getSubjectsByFinder(Form form) {
		// TODO Auto-generated method stub
		List<Subject> subjects = new ArrayList<>();
		
		if (!form.getName().isEmpty()&& !form.getCourse().getName().isEmpty()&& !form.getCourse().getCiclo().isEmpty()) {
			subjects =subjectRepository.findByNameContainingAndSubjectCourseCourseNameAndSubjectCourseCourseCiclo(form.getName(),form.getCourse().getName(),form.getCourse().getCiclo());
			System.out.println("entro en 1");
		} else {
			if (!form.getName().isEmpty()&& !form.getCourse().getName().isEmpty()) {
				System.out.println("entro en 2");
				subjects =subjectRepository.findByNameContainingAndSubjectCourseCourseName(form.getName(), form.getCourse().getName());
			} else {
				if (!form.getName().isEmpty()&& !form.getCourse().getCiclo().isEmpty()) {
					System.out.println("entro en 3");
					subjects =subjectRepository.findByNameContainingAndSubjectCourseCourseCiclo(form.getName(), form.getCourse().getCiclo());
				} else {
					if (!form.getCourse().getName().isEmpty()&& !form.getCourse().getCiclo().isEmpty()) {
						System.out.println("entro en 4");
						subjects =subjectRepository.findBySubjectCourseCourseNameAndSubjectCourseCourseCiclo(form.getCourse().getName(), form.getCourse().getCiclo());
					} else {
						if (!form.getName().isEmpty()) {
							System.out.println("entro en 5");
							subjects =subjectRepository.findByNameContaining(form.getName());
						} else {
							if (!form.getCourse().getName().isEmpty()) {
								System.out.println("entro en 6");
								subjects =subjectRepository.findBySubjectCourseCourseName(form.getCourse().getName());
							} else {
								if (!form.getCourse().getCiclo().isEmpty()) {
									System.out.println("entro en 7");
									subjects =subjectRepository.findBySubjectCourseCourseCiclo(form.getCourse().getCiclo());
								}
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		subjects = new ArrayList<Subject>(new LinkedHashSet<Subject>(subjects));
		for (Subject subject : subjects) {
			System.out.println(subject.getId());
		}
		
		return subjects;
	}

}
