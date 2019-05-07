package com.amit.SpringData.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.SpringData.model.User;
import com.amit.SpringData.repository.UserRepository;

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UserRepository repository;

	@GetMapping("/all")
	public List<User> findAll() {
		return repository.findAll();

	}

	@GetMapping("/{name}")
	public User findByName(@PathVariable final String name) {
		return repository.findByName(name);

	}

	@PostMapping("/load")
	public User load(@RequestBody final User user) {
		repository.saveAndFlush(user);
		return repository.findByName(user.getName());
	}

}
