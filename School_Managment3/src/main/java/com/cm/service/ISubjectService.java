package com.cm.service;

import java.util.List;

import com.cm.model.Form;
import com.cm.model.Subject;

public interface ISubjectService {
	
	public Subject saveSubject(Subject subject);
	
	public List<Subject> showSubjects();
	
	public Subject getSubjectById(Long id);
	
	public List<Subject> getSubjectsByName(String name);
	
	public List<Subject> getSubjectsByFinder(Form form);
	
	

}
