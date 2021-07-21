package com.cm.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cm.model.Course;
import com.cm.model.CoursePeriod;
import com.cm.model.Form;
import com.cm.model.Note;
import com.cm.model.NotesForm;
import com.cm.model.Student;
import com.cm.model.Subject;
import com.cm.model.SubjectCourse;
import com.cm.service.ICoursePeriodService;
import com.cm.service.ICourseService;
import com.cm.service.INoteService;
import com.cm.service.ISubjectCourseService;
import com.cm.service.ISubjectService;

@Controller
public class SubjectController {

	@Autowired
	private Subject subject;
	
	@Autowired
	private Note note;
	
	@Autowired
	private ISubjectCourseService subjectCourseService;
	
	@Autowired
	private ICoursePeriodService coursePeriodService;
	
	@Autowired
	private ICourseService courseService;
	
	@Autowired 
	private ISubjectService subjectService;
	
	@Autowired
	private INoteService noteService;
	
	@Autowired
	private Form form;
	
	@GetMapping("/materia/nuevo")
	public ModelAndView getFormSubject() {
		ModelAndView modelV=new ModelAndView("form-subject");
		modelV.addObject("form",form);
		modelV.addObject("courses",courseService.showCourses());
		return modelV;
	}
	
	@PostMapping("/materia/guardar")
	public ModelAndView saveSubject(@ModelAttribute("form") Form form) {
		ModelAndView modelV=new ModelAndView("redirect:/home");
		Subject newSubject = subjectService.saveSubject(form.getSubject());
		
		
		form.setCourseList(courseService.findCourseByNameAndCiclo(form.getCourse().getName(), form.getCourse().getCiclo()));
		
		List<SubjectCourse> subCoursList= new ArrayList<>();
		for (Course cours : form.getCourseList()) {
			SubjectCourse sC = new SubjectCourse();
			sC.setSubject(newSubject);
			sC.setCourse(cours);
			subCoursList.add(sC);
			
		}
		subCoursList=subjectCourseService.saveSubjectCourseList(subCoursList);
		
		
		List<Note> notes = new ArrayList<>();
			if (!subCoursList.get(0).getCourse().getCoursePeriod().isEmpty()) {
				for (SubjectCourse subC : subCoursList) {
					for (CoursePeriod couP : subC.getCourse().getCoursePeriod()) {
						Note note = new Note();
						note.setStatus("Cursando");
						note.setSubject(newSubject);
						note.setStudent(couP.getStudent());
						note.setPeriod(couP.getPeriod());
						notes.add(note);
					}
				}
				noteService.saveNotes(notes);
			}
	
			
				
		
		
		
		return modelV;
	}
	
	@GetMapping("/materia")
	public ModelAndView showSubjects() {
		ModelAndView modelV=new ModelAndView("list-subject");
		modelV.addObject("subjects",subjectService.showSubjects());
		modelV.addObject("form",new Form());
		
		return modelV;
	}
	@PostMapping("/materia/busqueda")
	public ModelAndView showSubjectsFind(@ModelAttribute("form") Form form) {
		ModelAndView modelV=new ModelAndView("list-subject");
		
		if (!form.getName().isEmpty()||!form.getCourse().getName().isEmpty()||!form.getCourse().getCiclo().isEmpty()) {
			modelV.addObject("subjects",subjectService.getSubjectsByFinder(form));
			modelV.addObject("form",new Form());
		} else {
			modelV.addObject("subjects",subjectService.showSubjects());
			modelV.addObject("form",new Form());
		}
		
		return modelV;
	}
	@GetMapping("/materia/detalles/{id}")
	public ModelAndView getDetailsSubject (@PathVariable(value = "id")Long id) {
		List<Note> notesF = new ArrayList<>();
		notesF= noteService.getBySubject(id);
		ModelAndView modelV=new ModelAndView("details-subject");
		modelV.addObject("notes", noteService.getBySubject(id));
		modelV.addObject("notesF", new NotesForm(notesF));
		
		
		return modelV;
	}
	@PostMapping("/materia/notas/guardar/{id}")
	public ModelAndView saveNotes(@PathVariable(value = "id")Long id,@ModelAttribute("notesF") NotesForm notesF) {
		
		ModelAndView modelV=new ModelAndView("redirect:/materia/detalles/"+id);
		
		for (Note note1 : notesF.getNotes()) {
			int prom=0;
			float cont=0;
			if (note1.getNote1()!=0) {
				prom=prom+note1.getNote1();
				cont++;
			}
			if (note1.getNote2()!=0) {
				prom=prom+note1.getNote2();
				cont++;
			}
			if (note1.getNote3()!=0) {
				prom=prom+note1.getNote3();
				cont++;
			}
			System.out.println(note1.getId());
			System.out.println("sssssssssssss");
			System.out.println(note1.getNote1());
			System.out.println(note1.getNote2());
			System.out.println(note1.getNote3());
			note1.setAverage((int)Math.round(prom/cont));
			if (note1.getAverage()>=6) {
				note1.setfNote(note1.getAverage());
				note1.setStatus("Aprobado");
			}else {
				note1.setStatus("Previa");
				note1.setfNote(0);
			}
		}
		
		noteService.saveNotes(notesF.getNotes());
		return modelV;
	}
}
