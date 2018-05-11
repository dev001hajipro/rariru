package com.github.dev001hajipro;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserRestController {
	@Autowired
	UserRepository userRepository;

	@GetMapping
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping(path = "{id}")
	public Optional<User> getUser(@PathVariable("id") Integer id) {
		return userRepository.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	// JSR-303
	public Optional<User> createUser(@Validated @RequestBody User user) {
		return Optional.of(userRepository.save(user));
	}

	@PutMapping
	public Optional<User> update(@PathVariable("id") Integer id, @RequestBody User user) {
		user.setId(id);
		return Optional.of(userRepository.save(user));
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);
	}
}
