package com.cm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cm.model.Note;

public interface INoteRepository extends CrudRepository<Note, Long>{
	
	List<Note> findBySubjectId(Long id);
	List<Note> findByStudentCoursePeriodCourseIdAndSubjectIdAndStudentCoursePeriodPeriod(Long idCou,Long idSub,int period);
	Note findBySubjectIdAndStudentId(Long idSubject,Long idStudent);
	List<Note> findBySubjectSubjectCourseCourseIdAndStudentIdAndPeriod(Long idCourse,Long idStudent,int period);
	List<Note> findByStudentId(Long id);
	List<Note> findBySubjectSubjectCourseCourseId(Long id);
	List<Note> findBySubjectSubjectCourseCourseIdAndSubjectSubjectCourseSubjectId(Long idCou,Long idSub);
}
