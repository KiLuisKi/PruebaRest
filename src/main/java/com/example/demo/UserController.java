package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.config.validate.ValidationException;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public Userss createUser(@RequestBody Userss user) {
		if (user.getName() == null && user.getBirthDate() == null) {
			throw new IllegalArgumentException("User name and birth date is required");
		}
		else if (user.getName() == null) {
			throw new IllegalArgumentException("User name is required");
		}
		else if (user.getBirthDate() == null) {
			throw new IllegalArgumentException("User birth date is required");
		}
		return userService.createUser(user);
	}

	@GetMapping("/{id}")
	public Userss getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PutMapping
	public Userss updateUser(@RequestBody Userss user) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
