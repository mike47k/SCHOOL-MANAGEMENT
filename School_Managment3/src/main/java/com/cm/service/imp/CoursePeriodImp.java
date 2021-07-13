package com.cm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.model.CoursePeriod;
import com.cm.repository.ICoursePeriodRepository;
import com.cm.service.ICoursePeriodService;
@Service
public class CoursePeriodImp implements ICoursePeriodService{
	
	@Autowired
	private ICoursePeriodRepository coursePeriodRepository;
	@Override
	public CoursePeriod saveCoursePeriod(CoursePeriod coursePeriod) {
		// TODO Auto-generated method stub
		return coursePeriodRepository.save(coursePeriod);
		
	}
	@Override
	public List<CoursePeriod> getCoursePeriodByIdAndYear(Long id,int year) {
		// TODO Auto-generated method stub
		return coursePeriodRepository.findByCourseIdAndPeriod(id,year);
	}
	@Override
	public CoursePeriod getById(Long id) {
		// TODO Auto-generated method stub
		return coursePeriodRepository.findById(id).get();
	}

}
