package com.userservice.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.main.VO.ResponseTemplateVO;
import com.userservice.main.entity.User;
import com.userservice.main.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("inside saveUser method of UserController");
		return userService.saveUser(user);

	}

	@GetMapping("/{id}")
	public ResponseTemplateVO findUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("inside findUserWithDepartment method of UserController");
		return userService.getUserWithDepartment(userId);
	}

}
