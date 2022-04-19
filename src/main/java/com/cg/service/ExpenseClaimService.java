package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Employee;
import com.cg.entity.ExpenseClaim;
import com.cg.exception.EmployeeException;
import com.cg.exception.ExpenseClaimException;
import com.cg.exception.ExpenseException;
import com.cg.exception.LoginDetailsException;
import com.cg.exception.ProjectException;
import com.cg.repository.EmployeeRepository;
import com.cg.repository.ExpenseClaimRepository;
import com.cg.repository.ExpenseRepository;
import com.cg.repository.LoginDetailsRepository;
import com.cg.repository.ProjectRepository;

@Service
public class ExpenseClaimService {
	@Autowired
	private ExpenseClaimRepository exClaimRepo;

	@Autowired
	private ProjectRepository pRepo;

	@Autowired
	private ExpenseRepository exRepo;

	@Autowired
	private EmployeeRepository eRepo;

	@Autowired
	private LoginDetailsRepository ldRepo;

	public List<ExpenseClaim> getAllExpenseClaim() {

		try {
			if (exClaimRepo.count() == 0) {
				throw new ExpenseClaimException("Expense Table is empty");
			}
		} catch (ExpenseClaimException ex) {
			throw ex;
		}
		return exClaimRepo.findAll();
	}

	public ExpenseClaim addExpenseClaim(ExpenseClaim expenseClaim) {

		int checkProjectId = expenseClaim.getProject().getProjectCode();
		int checkExpenseId = expenseClaim.getExpense().getExpenseCode();
		int checkEmployeeId = expenseClaim.getEmployee().getEmpId();
		int checkLoginDetailsId = expenseClaim.getEmployee().getLogindetails().getId();

		try {
			if (!pRepo.existsById(checkProjectId)) {
				throw new ProjectException("Project does not exist");
			} else if (!exRepo.existsById(checkExpenseId)) {
				throw new ExpenseException("Expense does not exist");
			} else if (!eRepo.existsById(checkEmployeeId)) {
				throw new EmployeeException("Employee does not exist");
			} else if (!ldRepo.existsById(checkLoginDetailsId)) {
				throw new LoginDetailsException("Login Detail does not exist");
			} else {
				return exClaimRepo.save(expenseClaim);
			}
		} catch (ProjectException ex) {
			throw ex;
		}
	}

	public ResponseEntity<Object> fetchExpenseClaimById(int id) {
		try {
			if (!exClaimRepo.existsById(id)) {
				throw new ExpenseClaimException("Expense Claim Not Found");
			}
		} catch (ExpenseClaimException ex) {
			throw ex;
		}
		return new ResponseEntity(exClaimRepo.findById(id).get(), HttpStatus.OK);

	}

	public ExpenseClaim updateExpenseClaim(ExpenseClaim expenseclaim) {
		int checkExpenseClaimCode = expenseclaim.getExpenseClaimId();
		String designation = exClaimRepo.findExpenseClaimByExpenseClaimId(checkExpenseClaimCode).getEmployee()
				.getEmpDesignation();

		try {
			if (!designation.equals("Project Manager")) {
				throw new ExpenseClaimException(
						"you do not have Project Manager privileges for pdating Expense Claim!");
			} else {
				return exClaimRepo.save(expenseclaim);
			}
		} catch (ExpenseClaimException ex) {
			throw ex;
		}
	}

	// modification: Return type to String
	public String deleteExpenseClaimById(int id) {

		try {
			if (!exClaimRepo.existsById(id)) {
				throw new ExpenseClaimException("No such claim exists");
			}
		} catch (ExpenseClaimException ex) {
			throw ex;
		}
		exClaimRepo.deleteById(id);
		return "Expense claim deleted successfully";
	}

	public ExpenseClaim getAllClaimsByEmployee(Employee emp) {
		String designation = emp.getEmpDesignation();

		try {
			if (!designation.equals("Project Manager")) {
				throw new ExpenseClaimException(
						"you do not have Project Manager privileges for viewing Expense Claims!");
			} else {
				return exClaimRepo.findExpenseClaimByEmployee(emp);
			}
		} catch (ExpenseClaimException ex) {
			throw ex;
		}
	}

}
