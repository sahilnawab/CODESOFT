package com.codesoft.course;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.aspectj.weaver.patterns.ConcreteCflowPointcut.Slot;
import org.hibernate.annotations.CreationTimestamp;

import com.codesoft.sloats.Slots;
import com.codesoft.students.Students;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
//course entity it will create table named course
@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_code")
	private long id;
	@Column(name = "course_title",unique = true)
	private String title;
	private String description;
	@CreationTimestamp				// database will auto save the date and time when course is created;
	private LocalDateTime createdAt;
	private int capacity;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "course")
	private List<Slots> schedule;
	
	@ManyToMany(mappedBy = "registeredCourse")							//relation with student entity many student 
	private Set<Students>StudentRegisterdWithcourses;					//		can be associated with many course
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	

	public List<Slots> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<Slots> schedule) {
		this.schedule = schedule;
	}

	public Set<Students> getStudentRegisterdWithcourses() {
		return StudentRegisterdWithcourses;
	}

	public void setStudentRegisterdWithcourses(Set<Students> studentRegisterdWithcourses) {
		StudentRegisterdWithcourses = studentRegisterdWithcourses;
	}

	
	
}
