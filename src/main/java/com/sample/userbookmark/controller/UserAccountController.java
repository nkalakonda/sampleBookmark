package com.sample.userbookmark.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.userbookmark.model.UserAccount;
import com.sample.userbookmark.repositories.UserAccountRepository;

@RestController
@RequestMapping("/users")
public class UserAccountController {
	
	@Autowired
	UserAccountRepository userAccountRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{userId}/details" )
	Optional<UserAccount> getUserDetails(@PathVariable String userId) {
		return this.userAccountRepository.findByUsername(userId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/all")
	List<UserAccount> getAllUsers() {
		return this.userAccountRepository.findAll();
	}

}
