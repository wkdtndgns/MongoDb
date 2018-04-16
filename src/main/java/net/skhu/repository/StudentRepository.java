package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import net.skhu.domain.Pagination;
import net.skhu.domain.Student;

public interface StudentRepository extends MongoRepository<Student, String>{

	Student findById(int id);

	 public default List<Student> findAll(Pagination pagination) {
	        PageRequest pageRequest = new PageRequest(
	                pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id");
	        Page<Student> page = this.findAll(pageRequest);
	        pagination.setRecordCount((int)page.getTotalElements());
	        return page.getContent();
	    }


	 	void deleteById(int id);




}
