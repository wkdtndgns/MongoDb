package net.skhu.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document(collection="department")
public class Department {

	String _id;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String departmentName;

}
