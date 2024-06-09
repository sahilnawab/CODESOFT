package com.codesoft.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserReposatory userReposatory;
	
	
	public User createUser(User user) {
		User newUser= userReposatory.save(user);
		if(newUser!=null) {
			return newUser;
		}
		else {
			throw new IllegalArgumentException("Somthing wrong contanct to admin");
		}
		
	
	}
}
