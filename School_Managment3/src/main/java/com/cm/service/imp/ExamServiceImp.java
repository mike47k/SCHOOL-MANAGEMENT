package com.cm.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.model.Exam;
import com.cm.repository.IExamRepository;
import com.cm.service.IExamService;

@Service
public class ExamServiceImp implements IExamService{
	@Autowired
	private IExamRepository examRepository;

	@Override
	public Exam saveExam(Exam exam) {
		// TODO Auto-generated method stub
		return examRepository.save(exam);
	}
	
	
	
	
}
