package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cg.entity.Expense;
import com.cg.exception.ExpenseException;
import com.cg.repository.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepo;
	
//	public List<Integer> getAllExpenseCode(){
//		
//	}
	
	public Expense addExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public List<Expense> getAllExpenses() {
		
		try {
			if (expenseRepo.count()==0) {
				throw new ExpenseException("Expense Table is empty");
			} 
		}
		catch(ExpenseException ex) {
			throw ex;
		}
		return expenseRepo.findAll();
	}
	
	public ResponseEntity<Object> getExpenseByCode(int code) {
		try {
			if (!expenseRepo.existsById(code)) {
				throw new ExpenseException("Expense Not Found");
			}
		}
		catch(ExpenseException ex){
			throw ex;
		}
		return new ResponseEntity(expenseRepo.findById(code).get(),HttpStatus.OK);	
	}
	
	public Expense updateExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public String deleteExpenseByCode(int code) {
		
		try {
			if (!expenseRepo.existsById(code)) {
				throw new ExpenseException("No such Expense exists");
			}
		}
		catch(ExpenseException ex){
			throw ex;
		}
		expenseRepo.deleteById(code);
		return "Record Deleted Successfully";
	}

	public void deleteAllExpense() {
		
		try {
			if (expenseRepo.count()==0) {
				throw new ExpenseException("Expense Table is empty, no record to delete");
			} 
		}
		catch(ExpenseException ex) {
			throw ex;
		}
		expenseRepo.deleteAll(); 
	}
	
	public Expense findByCode(int code) {
		
		try {
			if (!expenseRepo.existsById(code)) {
				throw new ExpenseException("Expense Not Found");
			}
		}
		catch(ExpenseException ex){
			throw ex;
		}
		return expenseRepo.findById(code).get();
	}
}
