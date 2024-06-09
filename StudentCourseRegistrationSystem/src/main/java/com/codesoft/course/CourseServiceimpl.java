package com.codesoft.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesoft.exceptions.CourseNotfoundException;
import com.codesoft.sloats.SlotReposatory;
import com.codesoft.sloats.Slots;
//service interface for buisness logic 
@Service
public class CourseServiceimpl implements CourseService{

	@Autowired
	private CourseReposatory courseReposatory;	
	
	@Autowired
	private SlotReposatory slotReposatory;
	
	//creating new course
	@Override
	public Course createCourse(CourseDto course) {
		Course newCourse= new  Course();
		newCourse.setTitle(course.getTitle());
		newCourse.setCapacity(course.getCapacity());
		newCourse.setDescription(course.getDescription());
		return courseReposatory.save(newCourse);
	}

	@Override
	public CourseDto toCourseDto(Course course) {
		CourseDto dto= new CourseDto(course.getTitle(), course.getDescription(), course.getCapacity());
		return dto;
	
	}

	@Override
	public Course createSlot(long courseId, Slots slot) {
		//find course by id
		Course course= courseReposatory.findById(courseId)		
				.orElseThrow(()->new CourseNotfoundException("course not found with id " +courseId ));
		Slots newSolt= new Slots();
		newSolt.setTimearange(slot.getTimearange());
		newSolt.setDate(slot.getDate());
		newSolt.setCourse(course);
				Course course1=courseReposatory.save(course);
				slotReposatory.save(newSolt);
		
		return course1;
	}
	
@Override
	public List<Course> listOfCourse() {
		return courseReposatory.findAll();
		
	}	
	
}
