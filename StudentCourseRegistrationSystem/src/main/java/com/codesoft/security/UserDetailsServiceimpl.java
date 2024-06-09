package com.codesoft.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codesoft.students.StudentReposatory;
import com.codesoft.students.Students;

@Service
public class UserDetailsServiceimpl implements UserDetailsService {

	@Autowired
	private StudentReposatory reposatory;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Students student = reposatory.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("No student was found with this email"));
		return student;
	}

}
