package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.LoginDetails;
import com.cg.exception.EmployeeException;
import com.cg.exception.LoginDetailsException;
import com.cg.repository.LoginDetailsRepository;

@Service
public class LoginDetailsService {
	@Autowired
	private LoginDetailsRepository lRepo;

	// Optional implementation
	public String addLoginDetails(LoginDetails logindetails) {
		String lUsername = logindetails.getlUserName();
		try {
			if (lRepo.existsBylUserName(lUsername)) {
				throw new EmployeeException("Login_Username already exists! Try with another username");
			} else {
				lRepo.save(logindetails);
			}
		} catch (LoginDetailsException ex) {
			throw ex;
		}
		return "Login Details Added";
	}

	// Illegal function :Employee record without login_Details reference is not
	// valid. LoginDetails will be deleted when employee record is deleted.
	public ResponseEntity<Object> deleteDetailsById(int id) {

		try {
			if (!lRepo.existsById(id)) {
				throw new EmployeeException("Login_Username with this Id does not exist!");
			} else {
				lRepo.deleteById(id);
			}
		} catch (LoginDetailsException ex) {
			throw ex;
		}
		return new ResponseEntity("LoginDetails Deleted successfully", HttpStatus.OK);
	}

	// return type changes to be made
	public String validateUser(LoginDetails logindetails) {
		Boolean b = false;
		String lname = logindetails.getlUserName().toString();
		String lpass = logindetails.getlPassword().toString();
		String lrole = logindetails.getlRole().toString();
		List<LoginDetails> ld = lRepo.findAll();
		for (LoginDetails l : ld) {
			if (l.getlUserName().equals(lname) && l.getlPassword().equals(lpass) && l.getlRole().equals(lrole)) {
				b = true;
			}
		}
		if (b) {
			return "User exists";
		} else {
			return "User does not exist";
		}

	}

	// return type modified
	public String logOut(LoginDetails logindetails) {
		String lUsername = logindetails.getlUserName();
		try {
			if (!lRepo.existsBylUserName(lUsername)) {
				throw new EmployeeException("Login_Username does not exist! ");
			} else {
				lRepo.save(logindetails);
			}
		} catch (LoginDetailsException ex) {
			throw ex;
		}
		return "User: " + lUsername + " has logged out successfully!";
	}

}