package com.codesoft.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesoft.sloats.Slots;
//course controller for creating course and assign new slot for it
@RestController
@RequestMapping("api/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	// creating course
	@PostMapping("/create")
	public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto Course){
			Course Savedcourse=	courseService.createCourse(Course);
				CourseDto dto=	courseService.toCourseDto(Savedcourse);
				return new ResponseEntity<CourseDto>(dto, HttpStatus.CREATED);
			}
	//assign slot o the course
	@PatchMapping("/assiegnslot/course_Id/{courseId}")
	public ResponseEntity<?>assiegnSlot(@PathVariable long courseId,@RequestBody Slots slot){
		Course course=courseService.createSlot(courseId, slot);
		return new ResponseEntity<Course>(course, HttpStatus.OK); 
	}
	//get all available course for student to subscribe
	@GetMapping("/available_courses")
	public ResponseEntity<List<Course>> getAll(){
	List<Course>list=	courseService.listOfCourse();
	return new ResponseEntity<List<Course>>(list, HttpStatus.OK);
	}
	
	}
