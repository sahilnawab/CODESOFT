package com.codesoft.course;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseReposatory extends JpaRepository<Course, Long> {

	
	//find course based on course title from database;
	Optional<Course> findByTitle(String title); 
}
