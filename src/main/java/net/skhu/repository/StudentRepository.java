package net.skhu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.skhu.domain.Student;

public interface StudentRepository extends MongoRepository<Student, String>{

}
