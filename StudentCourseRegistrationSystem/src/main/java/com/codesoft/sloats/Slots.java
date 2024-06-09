package com.codesoft.sloats;

import java.time.LocalDate;

import com.codesoft.course.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// time slot entity for courses
@Entity
public class Slots {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name =" time_slot")
	private String timearange;
	@Column(name = "slot_date")
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	@JsonIgnore
	private Course course;
	
	
	
	 public Slots( String timearange, LocalDate date, Course course) {
		super();
	
		this.timearange = timearange;
		this.date = date;
		this.course = course;
	}

	public Slots() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTimearange() {
		return timearange;
	}

	public void setTimearange(String timearange) {
		this.timearange = timearange;
	}

	public LocalDate getDate() {
		return date;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	 
}
