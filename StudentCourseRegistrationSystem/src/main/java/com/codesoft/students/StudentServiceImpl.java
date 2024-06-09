package com.codesoft.students;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codesoft.course.Course;
import com.codesoft.course.CourseReposatory;
import com.codesoft.exceptions.CourseAlreadyExistException;
import com.codesoft.exceptions.CourseNotfoundException;
import com.codesoft.exceptions.StudentNotfoundException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentReposatory studentReposatory;
	
	@Autowired
	private CourseReposatory courseReposatory;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	@Override
	public Set<Course> SelectCourse(long studentid, long courseid) {
		//find student by id
	Students student=	studentReposatory.findById(studentid)				
			.orElseThrow(()->new StudentNotfoundException("student not found with id " +studentid ));
	//find course by id
	Course course= courseReposatory.findById(courseid)		
			.orElseThrow(()->new CourseNotfoundException("course not found with id " +courseid ));
	Set<Course> registerdCourse= new HashSet<Course>();
	//fetch already registered course
	registerdCourse=student.getRegisteredCourse();
	//if course already registered throw exception
	if(registerdCourse.contains(course)) {
		throw new CourseAlreadyExistException("course already already registered");
	}
	registerdCourse.add(course);	
	student.setRegisteredCourse(registerdCourse);
//save updated registration in database
	studentReposatory.save(student);
	Set<Students> registerdStudent= new HashSet<Students>();
	registerdStudent=course.getStudentRegisterdWithcourses();
	registerdStudent.add(student);
	course.setStudentRegisterdWithcourses(registerdStudent);
//save updated list of student in database
	courseReposatory.save(course);
	return student.getRegisteredCourse();
	}

	@Override
	public boolean removeCourse(long studentid, long courseid) {
		//find student by id
		Students student=	studentReposatory.findById(studentid)				
				.orElseThrow(()->new StudentNotfoundException("student not found with id " +studentid ));
		//find course by id
		Course course= courseReposatory.findById(courseid)		
				.orElseThrow(()->new CourseNotfoundException("course not found with id " +courseid ));
		Set<Course> registerdCourse= new HashSet<Course>();
		//fetch already registered course
		registerdCourse=student.getRegisteredCourse();
		//if course is subscribed 
		if(registerdCourse.contains(course)) {
			//unsubscribed
			registerdCourse.remove(course);
		}
		Set<Students> registerdStudent= new HashSet<Students>();
		registerdStudent=course.getStudentRegisterdWithcourses();
		registerdStudent.remove(student);
		//save student
		studentReposatory.save(student);
		//save course
		courseReposatory.save(course);
		return true;		
	}

	@Override
	public StudentDto toStudentDto(Students student) {
			StudentDto dto= new StudentDto();
			dto.setName(student.getName());
			dto.setAge(student.getAge());
		return dto;
	}

	@Override
	public Students register(Students student) {
		Students newStudent= new Students();
		newStudent.setName(student.getName());
		newStudent.setAge(student.getAge());
		newStudent.setEmail(student.getEmail());
		newStudent.setPassword(encoder.encode(student.getPassword()));
		newStudent.setRole("ROLE_STUDENT");
	return	studentReposatory.save(newStudent);
	
	}

	@Override
	public List<StudentDto> getAll() {
		List<StudentDto>dtos= new ArrayList<StudentDto>();
		List<Students>students=studentReposatory.findAll();
		dtos=students.stream().map(this::toStudentDto).collect(Collectors.toList());
		return dtos ;
	}


}
