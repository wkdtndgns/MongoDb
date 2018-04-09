package net.skhu.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="Student")
public class Student {

	String _id;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

    String studentNumber;
    String name;
    int year;
    int departmentId;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    Department department;



}
