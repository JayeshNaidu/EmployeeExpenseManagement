//package com.cg.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.cg.entity.Expense;
//import com.cg.repository.ExpenseRepository;
//import com.cg.service.ExpenseService;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class TestExpense {
//	@Autowired
//	ExpenseService expenseService;
//
//	@MockBean
//	ExpenseRepository expenseRepo;
//
//	// expenseVariables
//	Expense ex;
//	int expenseCode;
//	String expenseType, expenseDescription;
//	String ans;
//
//	@BeforeEach
//	void setUp() {
//
//		// expense setUp
//		expenseCode = 805;
//		expenseType = "akash";
//		expenseDescription = "1Ab@cdeaa";
//
//		ex = new Expense(expenseCode, expenseType, expenseDescription);
//
//		ans = "Expense [expenseCode=" + expenseCode + ", expenseType=" + expenseType + ", expenseDescription="
//				+ expenseDescription + "]";
//	}
//
//	// create
//	@Test
//	@Order(1)
//	public void testAddExpense() {
//		when(expenseRepo.save(ex)).thenReturn(ex);
//		assertEquals(ans, expenseService.addExpense(ex).toString());
//	}
//
//	@Test
//	@Order(2)
//	public void testGetExpenseByExpenseType() {
//		when(expenseRepo.findByExpenseType(expenseType)).thenReturn(ex);
//
//	}
//
//	@Test
//	@Order(3)
//	public void testUpdateExpense() {
//		when(expenseRepo.save(ex)).thenReturn(ex);
//		when(expenseRepo.findByExpenseType(expenseType)).thenReturn(ex);
//		ex.setExpenseType("Food");
//		String test3 = "Expense [expenseCode=" + expenseCode + ", expenseType=" + "Food" + ", expenseDescription="
//				+ expenseDescription + "]";
//		when(expenseRepo.save(ex)).thenReturn(ex);
//		assertEquals(test3, expenseService.updateExpense(ex).toString());
//
//	}
//
//	@Test
//	@Order(4)
//	public void testdeleteExpense() {
//		expenseService.deleteExpense(ex);
//		verify(expenseRepo, times(1)).delete(ex);
//
//	}
//
//}
