package com.cg.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.entity.Expense;
import com.cg.repository.ExpenseRepository;
import com.cg.service.ExpenseService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestExpense {
	@Autowired
	ExpenseService expenseService;
	
	@Autowired
	ExpenseRepository expenseRepo;
	
	@Test
	@Order(1)
	public void testAddExpense() {
		Expense exp=new Expense();
		exp.setExpenseType("Travel");
		exp.setExpenseDescription("Flight Ticket");
		expenseRepo.save(exp);
		assertEquals("Travel", expenseRepo.findById(1).get().getExpenseType());
	}
	
	@Test
	@Order(2)
	public void testGetAllExpense() {
		assertEquals(1, expenseRepo.count());
	}
	
	@Test
	@Order(3)
	public void testUpdateExpense() {
		Expense e = expenseRepo.findById(1).get();
		e.setExpenseDescription("Train Ticket");
		expenseRepo.save(e);
		assertEquals("Train Ticket", expenseRepo.findById(1).get().getExpenseDescription());
	}
	
	@Test
	@Order(4)
	public void testFindByCode() {
		Optional<Expense> ex=expenseRepo.findById(1);
		assertEquals(ex.toString(), expenseRepo.findById(1).toString());
	}
	
	@Test
	@Order(5)
	public void testDeleteExpenseByCode() {
		assertEquals("Record Deleted Successfully", expenseService.deleteExpenseByCode(1));
	}
	
	@Test
	@Order(6)
	public void testDeleteAllExpense() {
		expenseRepo.deleteAll();
		assertEquals(0, expenseRepo.count());
	}
}
