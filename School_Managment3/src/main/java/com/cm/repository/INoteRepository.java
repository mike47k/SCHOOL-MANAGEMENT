package com.cm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cm.model.Note;

public interface INoteRepository extends CrudRepository<Note, Long>{
	
	List<Note> findBySubjectId(Long id);
	Note findBySubjectIdAndStudentId(Long idSubject,Long idStudent);
	List<Note> findBySubjectSubjectCourseCourseIdAndStudentId(Long idCourse,Long idStudent);
	List<Note> findByStudentId(Long id);
	List<Note> findBySubjectSubjectCourseCourseId(Long id);
}
