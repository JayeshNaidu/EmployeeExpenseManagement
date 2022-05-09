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
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.cg.entity.Employee;
//import com.cg.entity.LoginDetails;
//import com.cg.repository.EmployeeRepository;
//import com.cg.repository.LoginDetailsRepository;
//import com.cg.service.EmployeeService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class TestEmployee {
//	@Autowired
//	EmployeeService eService;
//
//	@MockBean
//	EmployeeRepository eRepo;
//
//	@MockBean
//	LoginDetailsRepository ldRepo;
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
//	@BeforeEach
//	void setUp() {
//
//		// Login setUp
//		lid = 805;
//		lusername = "akash";
//		lpassword = "1Ab@cdeaa";
//		lrole = "Tester";
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
//		ld = new LoginDetails(lid, lusername, lpassword, lrole);
//
//		// save loginDetails
//
//		e = new Employee(empId, empName, empPAN, empDesignation, empDomain, empDOJ, empDOB, empSalary, empEmailId,
//				emp_userName, emp_password, emp_role, ld);
//
//		ans = "Employee [empId=" + empId + ", empName=" + empName + ", empPAN=" + empPAN + ", empDesignation="
//				+ empDesignation + ", empDomain=" + empDomain + ", empDOJ=" + empDOJ + ", empDOB=" + empDOB
//				+ ", empSalary=" + empSalary + ", empEmailId=" + empEmailId + ", userName=" + emp_userName
//				+ ", password=" + emp_password + ", role=" + emp_role + ", logindetails=" + ld + "]";
//
//	}
//
//	// create
//	@Test
//	@Order(1)
//	public void testAddEmployee() {
//		when(ldRepo.save(ld)).thenReturn(ld);
//		when(eRepo.save(e)).thenReturn(e);
//		assertEquals(ans, eService.addEmployeefortest(e).toString());
//	}
//
//	@Test
//	@Order(2)
//	public void testGetEmployeeByEmpname() {
//
//		when(eRepo.findByEmpName(empName)).thenReturn(e);
//		assertEquals(ans, eService.GetEmployeeByEmpname(e).toString());
//	}
//
//	@Test
//	@Order(3)
//	public void testUpdateEmployee() {
//		when(eRepo.save(e)).thenReturn(e);
//		when(eRepo.findByEmpName(empName)).thenReturn(e);
//		e.setEmpName("aaron");
//		String test3 = "Employee [empId=" + empId + ", empName=" + "aaron" + ", empPAN=" + empPAN + ", empDesignation="
//				+ empDesignation + ", empDomain=" + empDomain + ", empDOJ=" + empDOJ + ", empDOB=" + empDOB
//				+ ", empSalary=" + empSalary + ", empEmailId=" + empEmailId + ", userName=" + emp_userName
//				+ ", password=" + emp_password + ", role=" + emp_role + ", logindetails=" + ld + "]";
//		when(eRepo.save(e)).thenReturn(e);
//		assertEquals(test3, eService.updateEmployee(e).toString());
//	}
//
//	@Test
//	@Order(4)
//	public void testDeleteEmployee() {
//		eService.deleteEmployee(e);
//		verify(eRepo, times(1)).delete(e);
//
//	}
//
//}
