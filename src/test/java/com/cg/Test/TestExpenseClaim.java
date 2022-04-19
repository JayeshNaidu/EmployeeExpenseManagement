package com.cg.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.entity.Employee;
import com.cg.entity.Expense;
import com.cg.entity.ExpenseClaim;
import com.cg.entity.LoginDetails;
import com.cg.entity.Project;
import com.cg.repository.ExpenseClaimRepository;
import com.cg.service.ExpenseClaimService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestExpenseClaim {

	@Autowired
	ExpenseClaimService expenseClaimService;

	@Autowired
	ExpenseClaimRepository expenseClaimRepo;

	@Test
	@Order(1)
	public void testAddExpenseClaim() {
		ExpenseClaim expClaim = new ExpenseClaim();
		expClaim.setExpenseAmount(5000);
		expClaim.setStartDate(LocalDate.parse("12-12-2017", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		expClaim.setEndDate(LocalDate.parse("31-10-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")));

		// Setting Employee for ExpenseClaim as Employee is one of it's aggregated
		// members.
		Employee e = new Employee();
		LoginDetails ld = new LoginDetails();
		ld.setlUsername("akash");
		ld.setlPassword("1Ab@cdeaa");
		ld.setlRole("Tester");
		e.setEmpName("akash");
		e.setEmpPAN("10bxzpn");
		e.setEmpDesignation("Team Lead");
		e.setEmpDOJ("05-11-2021");
		e.setEmpDOB("05-11-2021");
		e.setEmpDomain("Spring");
		e.setEmpEmailId("akash@gmail.com");
		e.setEmpSalary(80000);
		e.setUserName("akash");
		e.setPassword("1Ab@cdeaa");
		e.setRole("Team Lead");
		e.setLogindetails(ld);
		expClaim.setEmployee(e);

		// Setting Project for ExpenseClaim as Project is one of it's aggregated
		// members.
		Project project = new Project();
		project.setStartDate(LocalDate.parse("11-08-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		project.setEndDate(LocalDate.parse("12-12-2025", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		project.setProjectDescription("Expense Management Software");
		expClaim.setProject(project);

		// Setting Expense for ExpenseClaim as Expense is also one of it's aggregated
		// members.
		Expense expense = new Expense();
		expense.setExpenseType("Accomodation");
		expense.setExpenseDescription("Hotel stay at Mumbai");
		expClaim.setExpense(expense);

		// Saving the final ExpenseClaim object to the repository.
		expenseClaimRepo.save(expClaim);

		assertEquals(1, expenseClaimRepo.count());
	}

	@Test
	@Order(2)
	public void testGetAllExpenseClaim() {
		assertEquals(1, expenseClaimRepo.count());
	}

	@Test
	@Order(3)
	public void testFetchExpenseClaimById() {
		Optional<ExpenseClaim> ex = expenseClaimRepo.findById(1);
		assertEquals(ex.toString(), expenseClaimRepo.findById(1).toString());
	}

	@Test
	@Order(4)
	public void testUpdateExpenseClaim() {
		ExpenseClaim exClaim = expenseClaimRepo.findById(1).get();
		exClaim.setExpenseAmount(10000);
		assertNotEquals(5000, exClaim.getExpenseAmount());
	}

	@Test
	@Order(5)
	public void testDeleteExpenseClaimById() {
		assertEquals("Expense claim deleted successfully", expenseClaimService.deleteExpenseClaimById(1));
	}
}
