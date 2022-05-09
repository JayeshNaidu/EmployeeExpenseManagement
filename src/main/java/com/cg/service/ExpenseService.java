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

	public Expense addExpense(Expense expense) {
		int checkExCode = expense.getExpenseCode();
		try {
			if (expenseRepo.existsById(checkExCode)) {
				throw new ExpenseException("Expense Claim already exists");
			} else {
				return expenseRepo.save(expense);
			}
		} catch (ExpenseException ex) {
			throw ex;
		}

	}

	public List<Expense> getAllExpenses() {
		try {
			if (expenseRepo.count() == 0) {
				throw new ExpenseException("Expense Table is empty");
			} else {
				return expenseRepo.findAll();
			}
		} catch (ExpenseException ex) {
			throw ex;
		}
	}

	public ResponseEntity<Object> getExpenseByCode(int code) {
		try {
			if (!expenseRepo.existsById(code)) {
				throw new ExpenseException("Expense Not Found");
			} else {
				return new ResponseEntity<Object>(expenseRepo.findById(code).get(), HttpStatus.OK);
			}
		} catch (ExpenseException ex) {
			throw ex;
		}

	}

	public Expense updateExpense(Expense expense) {
		return expenseRepo.save(expense);
	}

	public String deleteExpenseByCode(int code) {

		try {
			if (!expenseRepo.existsById(code)) {
				throw new ExpenseException("No such Expense exists");
			} else {
				expenseRepo.deleteById(code);
				return "Record Deleted Successfully";
			}
		} catch (ExpenseException ex) {
			throw ex;
		}
	}

	public void deleteAllExpense() {
		try {
			if (expenseRepo.count() == 0) {
				throw new ExpenseException("Expense Table is empty, no record to delete");
			} else {
				expenseRepo.deleteAll();
			}
		} catch (ExpenseException ex) {
			throw ex;
		}
	}

	public Expense findByCode(int code) {
		try {
			if (!expenseRepo.existsById(code)) {
				throw new ExpenseException("Expense Not Found");
			} else {
				return expenseRepo.findById(code).get();
			}
		} catch (ExpenseException ex) {
			throw ex;
		}
	}

	// methods for testcase specific

	public Expense GetExpenseByExpenseType(Expense expense) {
		return expenseRepo.findByExpenseType(expense.getExpenseType());
	}

	public void deleteExpense(Expense ex) {
		expenseRepo.delete(ex);
	}
}