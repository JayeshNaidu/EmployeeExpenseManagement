package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Employee;
import com.cg.entity.ExpenseClaim;

public interface ExpenseClaimRepository extends JpaRepository<ExpenseClaim, Integer> {

	ExpenseClaim findExpenseClaimByEmployee(Employee emp);

	ExpenseClaim findExpenseClaimByProjectProjectCode(int projectId);

	ExpenseClaim findExpenseClaimByExpenseClaimId(int checkExpenseClaimCode);

	ExpenseClaim findByExpenseAmount(double expenseAmount);
}
