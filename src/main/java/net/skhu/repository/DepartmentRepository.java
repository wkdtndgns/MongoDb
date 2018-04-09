package net.skhu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.skhu.domain.Department;

public interface DepartmentRepository  extends MongoRepository<Department, String>{

}
