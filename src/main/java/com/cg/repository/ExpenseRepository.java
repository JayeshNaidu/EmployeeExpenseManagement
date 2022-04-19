package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Employee;
import com.cg.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

	Employee findByExpenseType(String string);

}
