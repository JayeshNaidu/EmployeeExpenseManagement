package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.LoginDetails;
import com.cg.service.LoginDetailsService;

@RestController
public class LoginDetailsController {

	@Autowired
	private LoginDetailsService lService;

	@PostMapping("/addLoginDetails")
	public LoginDetails addLoginDetails(@RequestBody LoginDetails logindetails) {
		return lService.addLoginDetails(logindetails);
	}

	// Delete employee in order to delete Login Details
	@DeleteMapping("/deleteLoginDetails/{id}")
	public ResponseEntity<Object> deleteLoginDetails(@PathVariable("id") int id) {
		return lService.deleteDetailsById(id);
	}

	@PostMapping("/validateUser")
	public String validateUser(@RequestBody LoginDetails logindetails) {
		return lService.validateUser(logindetails);
	}

	@PostMapping("/logOut")
	public String logOut(@RequestBody LoginDetails logindetails) {
		return lService.logOut(logindetails);
	}

}