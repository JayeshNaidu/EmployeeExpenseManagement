//package com.cg.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
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
//import com.cg.entity.Employee;
//import com.cg.entity.Expense;
//import com.cg.entity.ExpenseClaim;
//import com.cg.entity.LoginDetails;
//import com.cg.entity.Project;
//import com.cg.repository.EmployeeRepository;
//import com.cg.repository.ExpenseClaimRepository;
//import com.cg.repository.ExpenseRepository;
//import com.cg.repository.LoginDetailsRepository;
//import com.cg.repository.ProjectRepository;
//import com.cg.service.ExpenseClaimService;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class TestExpenseClaim {
//
//	@Autowired
//	ExpenseClaimService expenseClaimService;
//
//	@MockBean
//	ExpenseClaimRepository exClaimRepo;
//
//	@MockBean
//	EmployeeRepository eRepo;
//
//	@MockBean
//	LoginDetailsRepository ldRepo;
//
//	@MockBean
//	ExpenseRepository expenseRepo;
//
//	@MockBean
//	ProjectRepository pRepo;
//
//	String ans;
//
//	// employee variables
//	Employee e;
//	int empId;
//	String empName, empPAN, empDesignation, empDomain, empDOJ, empDOB, empEmailId, emp_userName, emp_password, emp_role;
//	double empSalary;
//
//	// loginDetails variables
//	LoginDetails ld;
//	int lid;
//	String lusername, lpassword, lrole;
//
//	// Expense variables
//	Expense ex;
//	int expenseCode;
//	String expenseType, expenseDescription;
//
//	// Project variables
//	Project p;
//	int projectCode;
//	String projectDescription;
//	LocalDate startDate;
//	LocalDate endDate;
//
//	// ExpenseClaim variables
//	ExpenseClaim exClaim;
//	int expenseClaimId;
//	double expenseAmount;
//	LocalDate ExClaim_startDate;
//	LocalDate ExClaim_endDate;
//
//	@BeforeEach
//	void setUp() {
//
//		// Login setUp
//		lid = 805;
//		lusername = "akash";
//		lpassword = "1Ab@cdeaa";
//		lrole = "Tester";
//		// create LoginDetail Object
//		ld = new LoginDetails(lid, lusername, lpassword, lrole);
//
//		// EMP setUp
//		empId = 800;
//		empName = "akash";
//		empPAN = "BXZPN12";
//		empDesignation = "Team Lead";
//		empDOJ = "05-11-2021";
//		empDOB = "05-11-2021";
//		empDomain = "Cloud";
//		empEmailId = "akash@gmail.com";
//		empSalary = 60000;
//		emp_userName = "akash";
//		emp_password = "1Ab@cdeaa";
//		emp_role = "Tester";
//		// create employee Object
//		e = new Employee(empId, empName, empPAN, empDesignation, empDomain, empDOJ, empDOB, empSalary, empEmailId,
//				emp_userName, emp_password, emp_role, ld);
//
//		// Expense setUp
//		expenseCode = 805;
//		expenseType = "akash";
//		expenseDescription = "1Ab@cdeaa";
//		// create expense Object
//		ex = new Expense(expenseCode, expenseType, expenseDescription);
//
//		// Project setUp
//		projectCode = 500;
//		projectDescription = "Employee Expense System";
//		startDate = LocalDate.parse("31-10-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//		endDate = LocalDate.parse("12-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//		// create Project Object
//		p = new Project(projectCode, projectDescription, startDate, endDate);
//
//		// ExpenseClaim setUp
//		expenseClaimId = 980;
//		expenseAmount = 5000;
//		ExClaim_startDate = LocalDate.parse("12-12-2017", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//		ExClaim_endDate = LocalDate.parse("31-10-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//
//		exClaim = new ExpenseClaim(expenseClaimId, expenseAmount, ExClaim_startDate, ExClaim_endDate, ex, p, e);
//
//		ans = "ExpenseClaim [expenseClaimId=" + expenseClaimId + ", expenseAmount=" + expenseAmount + ", startDate="
//				+ ExClaim_startDate + ", endDate=" + ExClaim_endDate + ", expense=" + ex + ", project=" + p
//				+ ", employee=" + e + "]";
//
//	}
//
//	@Test
//	@Order(1)
//	public void testAddExpenseClaim() {
//		when(ldRepo.save(ld)).thenReturn(ld);
//		when(eRepo.save(e)).thenReturn(e);
//		when(expenseRepo.save(ex)).thenReturn(ex);
//		when(pRepo.save(p)).thenReturn(p);
//		when(exClaimRepo.save(exClaim)).thenReturn(exClaim);
//		assertEquals(ans, expenseClaimService.addExpenseClaimfortest(exClaim).toString());
//	}
//
//	@Test
//	@Order(2)
//	public void testGetExpenseClaimByAmount() {
//		when(exClaimRepo.findByExpenseAmount(expenseAmount)).thenReturn(exClaim);
//		assertEquals(ans, expenseClaimService.GetExpenseClaimByAmount(exClaim).toString());
//
//	}
//
//	@Test
//	@Order(3)
//	public void updateExpenseClaim() {
//		when(exClaimRepo.save(exClaim)).thenReturn(exClaim);
//		when(exClaimRepo.findByExpenseAmount(expenseAmount)).thenReturn(exClaim);
//		exClaim.setExpenseAmount(9800);
//		when(exClaimRepo.save(exClaim)).thenReturn(exClaim);
//		assertNotEquals(ans, expenseClaimService.UpdateExpenseClaimfortest(exClaim).toString());
//	}
//
//	@Test
//	@Order(4)
//	public void deleteExpenseClaim() {
//		expenseClaimService.deleteExpenseClaim(exClaim);
//		verify(exClaimRepo, times(1)).delete(exClaim);
//	}
//}
