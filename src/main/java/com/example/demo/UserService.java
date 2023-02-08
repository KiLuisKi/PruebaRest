package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.config.validate.ValidationException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Userss createUser(Userss user) {
		return userRepository.save(user);
	}

	public Userss getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public Userss updateUser(Userss user) {
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
