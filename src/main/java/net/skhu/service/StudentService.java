package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.domain.Student;
import net.skhu.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired StudentRepository studentRepository;

	public List<Student> findAll(){
		return studentRepository.findAll();
	}


	public void save(Student student) {

		 studentRepository.save(student);
	}

	public Student findById(int id) {
		return studentRepository.findById(id);
	}


}
