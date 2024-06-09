package com.codesoft.students;

import java.util.List;
import java.util.Set;

import com.codesoft.course.Course;
//student service interface for student buisness logic 
public interface StudentService {

	StudentDto toStudentDto(Students student);
	Students register(Students studentDto);
	Set<Course> SelectCourse(long studentid,long Courseid);
	boolean removeCourse(long studentid,long Courseid);
	List<StudentDto> getAll();
}
