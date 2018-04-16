package net.skhu.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.Data;


@Data
public class User {

	String _id;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String userName;

}
