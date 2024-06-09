package com.codesoft.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesoft.course.Course;
//rest controller which create API endpoint for creating ,deleting and also for subscribing the student to course 
@RestController
@RequestMapping("api/student")
public class StudentController {

	Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentReposatory repo;
	
	//to subscribe student to the course
	@PatchMapping("/courseregisteration/student-id/{studentId}/course-id/{courseId}")
	public ResponseEntity<List<Course>> subscribeCourse(@PathVariable long studentId,@PathVariable long courseId){
	Set<Course> setOfcurse=	studentService.SelectCourse(studentId, courseId);
		List<Course> courses= new ArrayList<Course>();
		courses= setOfcurse.stream()
						.collect(Collectors.toList());
		return new ResponseEntity<List<Course>>(courses, HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/unsubscribe/student-id/{studentId}/course-id/{courseId}")
	public ResponseEntity<String> unsubscribe(@PathVariable long studentId,@PathVariable long courseId){
	boolean isRemoved=	studentService.removeCourse(studentId, courseId);
	if(isRemoved) {
		return new ResponseEntity<String>("sucsessfully unsubscribed", HttpStatus.ACCEPTED);
	}
	else {
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
	}

	@GetMapping("/getall")
	public List<StudentDto> getAllStudentsList(){
		logger.info("this mehod was called");
		return studentService.getAll();
	}
	@GetMapping("/get/{id}")
	public Students getById(@PathVariable long id) {
		return repo.findById(id).orElseThrow(() -> new UsernameNotFoundException("not found"));
	}
}
