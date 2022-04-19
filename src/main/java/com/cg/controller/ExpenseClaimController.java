package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Employee;
import com.cg.entity.ExpenseClaim;
import com.cg.service.ExpenseClaimService;

@RestController
public class ExpenseClaimController {
	@Autowired
	ExpenseClaimService exClaimService;

	@GetMapping("/getAllExpenseClaim")
	public List<ExpenseClaim> getAllExpenseClaim() {
		return exClaimService.getAllExpenseClaim();
	}

	@PostMapping("/addExpenseClaim")
	public ExpenseClaim addExpenseClaim(@RequestBody ExpenseClaim expenseClaim) {
		return exClaimService.addExpenseClaim(expenseClaim);
	}

	@GetMapping("/fetchExpenseClaimById/{id}")
	public ResponseEntity fetchExpenseClaimById(@PathVariable("id") int id) {
		return exClaimService.fetchExpenseClaimById(id);
	}

	@PostMapping("/updateExpenseClaim")
	public ExpenseClaim updateExpenseClaim(@RequestBody ExpenseClaim expenseClaim) {
		return exClaimService.updateExpenseClaim(expenseClaim);
	}

	@DeleteMapping("/deleteExpenseClaimById/{id}")
	public String deleteExpenseClaimById(@PathVariable("id") int id) {
		return exClaimService.deleteExpenseClaimById(id);
	}

	@RequestMapping("/getAllClaimsByEmployee")
	public ExpenseClaim getAllClaimsByEmployee(@RequestBody Employee emp) {

		return exClaimService.getAllClaimsByEmployee(emp);
	}

}
