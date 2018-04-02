package net.skhu.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="Student")
public class Student {
	@Id
	String id;
	String name;
	String studentNumber;

}
