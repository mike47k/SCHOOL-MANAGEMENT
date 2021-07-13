package com.cm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.model.Student;
import com.cm.repository.IStudentRepository;
import com.cm.service.IStudentService;

@Service
public class StudentServiceImp implements IStudentService {

	@Autowired
	private IStudentRepository studentRepository;
	



	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
		
	}




	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return (List<Student>) studentRepository.findAll();
	}




	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}




	@Override
	public List<Student> showStudentFind(Long dni, String name, String surname, int edad, String status) {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<>();
		Boolean aux=true;
		System.out.println(edad);
		if (dni>0) {
			students=studentRepository.findByDni(dni);
			aux=false;
		}else {
			if (!name.isEmpty()&&!surname.isEmpty()&&edad>=0&&!status.isEmpty()) {
				aux=false;
				students=studentRepository.findByNameAndSurnameAndAgeGreaterThanEqualAndStatus(name, surname, edad, status);
			} else {
				if (!name.isEmpty() && edad>=0) {
					aux=false;
					students=studentRepository.findByNameAndAgeGreaterThanEqual(name, edad);
				}
				if (!surname.isEmpty() && edad>=0) {
					aux=false;
					students=studentRepository.findBySurnameAndAgeGreaterThanEqual(surname, edad);
				}
				if (!status.isEmpty() && edad>=0) {
					aux=false;
					students=studentRepository.findByStatusAndAgeGreaterThanEqual(status, edad);
				}else if (name.isEmpty()&&surname.isEmpty()&&edad>=0&&status.isEmpty()) {
					aux=false;
					
					students=studentRepository.findByAgeGreaterThanEqual(edad);
				}

			}
			
		}
		
			
		
		
		if (aux) {
			students=(List<Student>) studentRepository.findAll();
		}
		return students;
	}
}
