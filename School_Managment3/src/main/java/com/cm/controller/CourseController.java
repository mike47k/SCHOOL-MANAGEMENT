package com.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cm.model.Course;
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
	public ModelAndView saveCourse(@ModelAttribute("course")Course course) {
		ModelAndView modelV=new ModelAndView("redirect:/home");
		courseService.saveCourse(course);
		return modelV;
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
		modelV.addObject("coursePeriods", coursePeriodService.getCoursePeriodByIdAndYear(id, year));
		//modelV.addObject("courseD", courseService.findCourseById(id));
		//modelV.addObject("notes", noteService.getByCourse(coursePeriodService.getById(id).getCourse().getId()));
		
		return modelV;
	}

}
