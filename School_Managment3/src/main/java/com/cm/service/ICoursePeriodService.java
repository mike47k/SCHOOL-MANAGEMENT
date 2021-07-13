package com.cm.service;

import java.util.List;

import com.cm.model.CoursePeriod;

public interface ICoursePeriodService {

	public CoursePeriod saveCoursePeriod(CoursePeriod coursePeriod);
	
	public List<CoursePeriod> getCoursePeriodByIdAndYear(Long id,int year);
	
	public CoursePeriod getById(Long id);
}
