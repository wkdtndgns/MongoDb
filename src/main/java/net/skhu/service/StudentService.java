package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.domain.Pagination;
import net.skhu.domain.Student;
import net.skhu.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired StudentRepository studentRepository;

	public List<Student> findAll(Pagination pagination){
		return studentRepository.findAll(pagination);
	}


	public void save(Student student) {

		 studentRepository.save(student);
	}

	public Student findById(int id) {
		return studentRepository.findById(id);
	}

	public long count() {
		return studentRepository.count();
	}

	public void delete(int id) {
		studentRepository.deleteById(id);

	}



}
