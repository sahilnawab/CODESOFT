package com.codesoft.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codesoft.students.StudentDto;
import com.codesoft.students.StudentReposatory;
import com.codesoft.students.StudentService;
import com.codesoft.students.Students;

@RestController
@RequestMapping("api/auth")
public class AuthController {

	@Autowired
	private StudentService studentService;
	
	//to register new student
		@PostMapping("/register")
		@ResponseStatus(code = HttpStatus.CREATED)
		public StudentDto Register(@RequestBody Students student){
			Students student1 =	studentService.register(student);
			return studentService.toStudentDto(student1);
		
		}
}
