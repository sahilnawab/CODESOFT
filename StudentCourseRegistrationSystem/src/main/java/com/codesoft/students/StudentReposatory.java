package com.codesoft.students;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentReposatory extends JpaRepository<Students, Long> {
	// Responsible for database DML operations

	// will search student based on name in database
	Optional<Students> findByEmail(String email);
}
