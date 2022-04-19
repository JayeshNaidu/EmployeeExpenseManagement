package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Employee;
import com.cg.entity.Expense;
import com.cg.service.ExpenseService;

@RestController
public class ExpenseController {
	@Autowired
	private ExpenseService exService; 
	
	@PostMapping("/addExpense")
	public Expense addExpense(@RequestBody Expense expense) {
		return exService.addExpense(expense);
	}
	
	@GetMapping("/getAllExpenses")
	public List<Expense> getAllExpenses(){
		return exService.getAllExpenses();
	}
	
	@GetMapping("/getExpenseByCode/{code}")
	public ResponseEntity getEmployee(@PathVariable("code") int code) {
		return exService.getExpenseByCode(code);
	}
	
	@PostMapping("/updateExpense")
	public Expense updateExpense(@RequestBody Expense expense) {
		return exService.updateExpense(expense);
	}
	
	@DeleteMapping("/deleteExpenseByCode/{code}")
	public String deleteExpenseByCode(@PathVariable("code") int code) {
		return exService.deleteExpenseByCode(code);
	}
	
	@DeleteMapping("/deleteAllExpense")
	public void deleteAllExpense(){
		exService.deleteAllExpense();
	}
	
	@GetMapping("/findByCode/{code}")
	public Expense findByCode(@PathVariable("code") int code) {
		return exService.findByCode(code);
	}
}
