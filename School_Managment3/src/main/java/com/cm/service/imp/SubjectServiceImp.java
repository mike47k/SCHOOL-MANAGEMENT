package com.cm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
