package com.cm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.model.Note;
import com.cm.repository.INoteRepository;
import com.cm.service.INoteService;

@Service
public class NoteServiceImp implements INoteService{

	
	@Autowired
	private INoteRepository noteRepository;
	
	@Override
	public List<Note> getBySubject(Long id) {
		// TODO Auto-generated method stub
		return noteRepository.findBySubjectId(id);
	}

	@Override
	public List<Note> getByStudent(Long id) {
		// TODO Auto-generated method stub
		return noteRepository.findByStudentId(id);
	}

	@Override
	public void saveNote(Note note) {
		// TODO Auto-generated method stub
		noteRepository.save(note);
		
	}

	@Override
	public void saveNotes(List<Note> notes) {
		// TODO Auto-generated method stub
		System.out.println("en el service de note");
		System.out.println();
		noteRepository.saveAll(notes);
	}

	@Override
	public List<Note> getByCourse(Long id) {
		// TODO Auto-generated method stub
		return noteRepository.findBySubjectSubjectCourseCourseId(id);
	}

	@Override
	public List<Note> getBySubjectCourseAndStudent(Long idCourse, Long idStudent) {
		// TODO Auto-generated method stub
		return noteRepository.findBySubjectSubjectCourseCourseIdAndStudentId(idCourse, idStudent);
	}

	@Override
	public Note getBySubjectAndStudent(Long idSubject, Long idStudent) {
		// TODO Auto-generated method stub
		return noteRepository.findBySubjectIdAndStudentId(idSubject, idStudent);
	}

	@Override
	public Note getByID(Long id) {
		// TODO Auto-generated method stub
		return noteRepository.findById(id).get();
	}

}
