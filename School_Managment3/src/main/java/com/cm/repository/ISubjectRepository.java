package com.cm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cm.model.Subject;

public interface ISubjectRepository extends CrudRepository<Subject, Long>{

	List<Subject> findByNameContaining(String name);
}
