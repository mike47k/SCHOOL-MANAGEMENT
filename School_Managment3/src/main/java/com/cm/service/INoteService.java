package com.cm.service;

import java.util.List;

import com.cm.model.Note;

public interface INoteService {

	public List<Note> getBySubject(Long id);
	public Note getBySubjectAndStudent(Long idSubject,Long idStudent);
	public Note getByID(Long id);
	public List<Note> getBySubjectCourseAndStudent(Long idCourse,Long idStudent);
	public List<Note> getByStudent(Long id);
	public List<Note> getByCourse(Long id);
	public void saveNote (Note note);
	public void saveNotes(List<Note> notes);
}
