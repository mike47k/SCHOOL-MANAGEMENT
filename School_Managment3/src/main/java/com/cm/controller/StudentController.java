package com.cm.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cm.model.CoursePeriod;
import com.cm.model.Exam;
import com.cm.model.Form;
import com.cm.model.Note;
import com.cm.model.NotesForm;
import com.cm.model.Student;
import com.cm.model.Subject;
import com.cm.model.SubjectCourse;
import com.cm.pdfGenerator.StudentsPDFExporter;
import com.cm.service.ICoursePeriodService;
import com.cm.service.ICourseService;
import com.cm.service.IExamService;
import com.cm.service.INoteService;
import com.cm.service.IStudentService;
import com.cm.service.ISubjectCourseService;
import com.cm.service.imp.NoteServiceImp;
import com.lowagie.text.DocumentException;

@Controller
public class StudentController {
	
	@Autowired
	private Student student;
	
	@Autowired
	private ICoursePeriodService coursePeriodService;
	
	@Autowired
	private CoursePeriod coursePeriod;
	
	@Autowired
	private IStudentService studentService;
	@Autowired 
	private ICourseService courseService;
	
	@Autowired
	private INoteService noteService;
	
	@Autowired
	private ISubjectCourseService subjectCourseService;
	
	@Autowired
	private IExamService examService;
	
	
	
	@GetMapping("/alumno/nuevo")
	public ModelAndView getFormStudent () {
		ModelAndView modelV=new ModelAndView("form-student");
		modelV.addObject("coursePeriod", coursePeriod);
		modelV.addObject("courses", courseService.showCourses());
		
		return modelV;
		
	}
	
	@GetMapping("/alumno")
	public ModelAndView showStudents() {
		ModelAndView modelV=new ModelAndView("list-student");
		modelV.addObject("students",studentService.getStudents());
		modelV.addObject("form",new Form());
		
		
		return modelV;
	}

	@GetMapping("/alumno/export")
	public void exportToPdf(HttpServletResponse response) throws DocumentException, IOException{
		response.setContentType("application/pdf");

		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

		String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=alumnos_" + currentDateTime +".pdf";
		response.setHeader(headerKey, headerValue);
		List<Student> listStudents = studentService.getStudents();

		StudentsPDFExporter exporter = new StudentsPDFExporter(listStudents);
		exporter.export(response);
	}
	
	@PostMapping("/alumnos/busqueda")
	public ModelAndView showStudentsFind(@ModelAttribute("form") Form form) {
		System.out.println(form.getYear());
		System.out.println(form.getStudent().getDni());
		ModelAndView modelV=new ModelAndView("list-student");
		modelV.addObject("students",studentService.showStudentFind(form.getStudent().getDni(), form.getStudent().getName(), form.getStudent().getSurname(), form.getYear(), form.getStudent().getStatus()));
		modelV.addObject("form",new Form());
		
		
		return modelV;
	}

	@GetMapping("/alumno/rac/{id}")
	public ModelAndView getRacStudent (@PathVariable(value = "id")Long id) {
		Form form =new Form();
		Form form2 =new Form();
		form.setCoursePeriod(coursePeriodService.getById(id));
		form.setNotes(noteService.getBySubjectCourseAndStudentAndPeriod(coursePeriodService.getById(id).getCourse().getId(),coursePeriodService.getById(id).getStudent().getId(),coursePeriodService.getById(id).getPeriod()));
		ModelAndView modelV=new ModelAndView("rac-student");
		modelV.addObject("coursePeriod", coursePeriodService.getById(id));
		modelV.addObject("form",form);
		modelV.addObject("form2",form2);
		modelV.addObject("courses", courseService.showCourses());

		
		
		return modelV;
	}
	@PostMapping("/alumno/examen/guardar/{id}/{rac}")
	public ModelAndView saveExam(@PathVariable(value = "id")Long id,@PathVariable(value = "rac")Long rac,@ModelAttribute("form") Form form) {
		
		Note notaux = noteService.getBySubjectAndStudent(form.getSubject().getId(),id);
		
		Exam exAux = form.getExam();
		
		exAux.setNote(notaux);
		
		examService.saveExam(exAux);
		
		if (exAux.getNoteExam() > 5) {
			notaux.setfNote(exAux.getNoteExam());
			notaux.setStatus("Aprobado");
			noteService.saveNote(notaux);
		}
		
		ModelAndView modelV=new ModelAndView("redirect:/alumno/rac/"+ rac);
		return modelV;
	}
	
	@PostMapping("/alumno/curso/guardar/{id}")
	public ModelAndView saveCourse(@PathVariable(value = "id")Long id,@ModelAttribute("form") Form form) {
		System.out.println(form.getYear());
		System.out.println(form.getCourse().getId());
		form.setStudent(studentService.getStudentById(id));
		System.out.println("llllllllllllllllllllll");
		List<Note>notes=new ArrayList<>();
		
		form.setCourse(courseService.findCourseById(form.getCourse().getId()));
		CoursePeriod cP = new CoursePeriod();
		cP.setCourse(form.getCourse());
		cP.setStudent(form.getStudent());
		cP.setPeriod(form.getYear());
		List<SubjectCourse> sC= new ArrayList<>();
		sC = subjectCourseService.getSubjectCourseByCourseId(form.getCourse().getId());
		
		for (SubjectCourse sub : sC) {
			Note note = new Note();
			note.setSubject(sub.getSubject() );
			note.setStudent(form.getStudent());
			note.setStatus("Cursando");
			note.setPeriod(form.getYear());
			notes.add(note);
			
			
		}
		form.setCoursePeriod(coursePeriodService.saveCoursePeriod(cP));
		noteService.saveNotes(notes);
		
			
		ModelAndView modelV=new ModelAndView("redirect:/alumno/rac/"+ id);
		return modelV;
	}
	@PostMapping("/alumno/notas/guardar/{id}")
	public ModelAndView saveNotes(@PathVariable(value = "id")Long id,@ModelAttribute("notesF") NotesForm notesF) {
		System.out.println("sssssssssssssssssssssssssssssss");
		int year = noteService.getByID(notesF.getNotes().get(0).getId()).getPeriod();
		for (Note note1 : notesF.getNotes()) {
			note1.setPeriod(year);
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
		ModelAndView modelV=new ModelAndView("redirect:/alumno/rac/"+id);
		noteService.saveNotes(notesF.getNotes());
		return modelV;
	}

	
	@PostMapping("/alumno/guardar")
	public ModelAndView saveStudent(@Valid @ModelAttribute("coursePeriod") CoursePeriod cP, BindingResult resultadoValidacion) {
		ModelAndView modelV;
		if(resultadoValidacion.hasErrors()){
			modelV = new ModelAndView("form-student");	
			System.out.println("holaaaaaaa");
			return modelV;
		}else {
			modelV = new ModelAndView("redirect:/home");
			student=cP.getStudent();
			student.setStatus("Cursando");
			student.setDateOfInscription(LocalDate.now());
			cP.setStudent(student);
			cP.setStudent(studentService.saveStudent(cP.getStudent()));
			
			
			List<Note>notes=new ArrayList<>();
			cP.setCourse(courseService.findCourseById(cP.getCourse().getId()));
			
			
			for (SubjectCourse sub : subjectCourseService.getSubjectCourseByCourseId(cP.getCourse().getId())) {
				Note note = new Note();
				note.setSubject(sub.getSubject());
				note.setStudent(cP.getStudent());
				note.setPeriod(cP.getPeriod());
				notes.add(note);
				
				
			}
			coursePeriodService.saveCoursePeriod(cP);
			noteService.saveNotes(notes);
			
			
			
			return modelV;
		}

	}

}
