package com.springboot.blog.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.blog.entity.User;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.repository.UserRepository;
import com.springboot.blog.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public String resetpassowrd(String userNameOrEmailId,String Password) {
		Optional<User> userOptional=  userRepository.findByUsernameOrEmail(userNameOrEmailId, userNameOrEmailId);
		if (userOptional.isPresent()) {
			User user=new User();
			user.setEmail(userOptional.get().getEmail());
			user.setUsername(userOptional.get().getUsername());
			user.setId(userOptional.get().getId());
			user.setPassword(passwordEncoder.encode(Password));
		    userRepository.save(user);
		    
			return userOptional.get().getUsername()+" Your Password Has Been Changed...";
		}else {
			return "";
		}
		
	}

}
