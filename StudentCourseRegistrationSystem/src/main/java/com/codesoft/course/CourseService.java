package com.codesoft.course;

import java.util.List;

import com.codesoft.sloats.Slots;

public interface CourseService {

	Course createCourse(CourseDto course);
	CourseDto toCourseDto(Course course);
	Course createSlot(long CourseId,Slots slot);
	List<Course> listOfCourse();
	
}
