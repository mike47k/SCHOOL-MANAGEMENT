package com.cm.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cm.model.Course;
import com.cm.model.CoursePeriod;
import com.cm.service.ICoursePeriodService;
import com.cm.service.ICourseService;
import com.cm.service.INoteService;

@Controller
public class CourseController {
	
	@Autowired
	private Course course;
	
	@Autowired
	private ICourseService courseService;
	
	@Autowired
	private INoteService noteService;
	
	@Autowired
	private ICoursePeriodService coursePeriodService;
	
	@GetMapping("/curso/nuevo")
	public ModelAndView getFormCourse() {
		ModelAndView modelV=new ModelAndView("form-course");
		modelV.addObject("course",course); 
		return modelV;
		
	}
	
	@PostMapping("/curso/guardar")
	public ModelAndView saveCourse(@Valid @ModelAttribute("course")Course course, BindingResult resultadoValidacion) {

		if(resultadoValidacion.hasErrors()){
			ModelAndView modelV=new ModelAndView("form-course");	
			return modelV;
		}else {
			ModelAndView modelV=new ModelAndView("redirect:/home");
			courseService.saveCourse(course);
			return modelV;
		}
	}
	
	@GetMapping("/curso")
	public ModelAndView showCourses() {
		ModelAndView modelV=new ModelAndView("list-course");
		modelV.addObject("courses",courseService.showCourses());
		
		return modelV;
	}
	@GetMapping("/curso/detalles/{id}/{year}")
	public ModelAndView getDetailsCourse (@PathVariable(value = "id")Long id,@PathVariable(value = "year")int year) {
		ModelAndView modelV=new ModelAndView("details-course");
		List<CoursePeriod> difCouPer=new ArrayList<>();
		difCouPer.add(coursePeriodService.getCoursePeriodByIdAndYear(id, year).get(0));
		for (CoursePeriod cP : coursePeriodService.get2CoursePeriodDistincPeriodsByCourseId(id)) {
			boolean aux = true;
			for (CoursePeriod dif : difCouPer) {
				if (cP.getPeriod()==dif.getPeriod()) {
					aux = false;
				}
			}
			if (aux) {
				difCouPer.add(cP);
			}
			
		}
		
		modelV.addObject("coursePeriods", coursePeriodService.getCoursePeriodByIdAndYear(id, year));
		modelV.addObject("differentsPeriods", difCouPer);
		//modelV.addObject("courseD", courseService.findCourseById(id));
		//modelV.addObject("notes", noteService.getByCourse(coursePeriodService.getById(id).getCourse().getId()));
		
		return modelV;
	}

}
