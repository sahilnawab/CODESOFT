package com.codesoft.students;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class StudentDto {
	//validation at server side

	@NotEmpty(message = "name should not be empty")
	private String name;
	
	
@NotNull(message = "age should not be null")
	private int age; 


	public StudentDto() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
