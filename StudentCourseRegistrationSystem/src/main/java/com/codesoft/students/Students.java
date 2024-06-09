package com.codesoft.students;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.codesoft.course.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
//entity named student
@Entity
@Table(name = "Student")
public class Students implements UserDetails{

	@Id			//primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //id auto generation
	@Column(name = "Student_id")
	private long id;
	@Column(name = "Student_name")			//change column name in table
	private String name;
	private int age;
	private String email;
	private String password;
	private String role;
	@CreationTimestamp									// database will auto save the date and time when student is created;
	@Column(name = "created_at")			
	private LocalDate creationTime;
	
	@ManyToMany(fetch = FetchType.EAGER)	//eagerly fetch student and course
	@JoinTable(name = "studen_course",
	 joinColumns =  {
			@JoinColumn(name = "student_id")
	},inverseJoinColumns = {
			@JoinColumn(name="course_id")
	}
	 )
	@JsonIgnore
	private Set<Course>registeredCourse;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Course> getRegisteredCourse() {
		return registeredCourse;
	}

	public void setRegisteredCourse(Set<Course> registeredCourse) {
		this.registeredCourse = registeredCourse;
	}
	
	public Students() {
		// TODO Auto-generated constructor stub
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Students(long id, String name, int age, LocalDate creationTime, Set<Course> registeredCourse) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.creationTime = creationTime;
		this.registeredCourse = registeredCourse;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role));
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
