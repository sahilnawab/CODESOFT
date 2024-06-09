package com.codesoft.course;

import com.codesoft.sloats.Slots;

import jakarta.validation.constraints.NotEmpty;

public class CourseDto {

	@NotEmpty
	private String title;
	@NotEmpty
	private String description;
	private int capacity;
	public CourseDto(String title, String description, int capacity) {
		super();
		this.title = title;
		this.description = description;
		this.capacity = capacity;
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	
	
}
