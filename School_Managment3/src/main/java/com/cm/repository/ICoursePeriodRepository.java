package com.cm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cm.model.CoursePeriod;

public interface ICoursePeriodRepository extends CrudRepository<CoursePeriod, Long>{

	List<CoursePeriod> findByCourseIdAndPeriod(Long id,int year);
	List<CoursePeriod> findByCourseId(Long id);
	List<CoursePeriod> findByCourseIdOrderByPeriodAsc(Long id);
	
}
