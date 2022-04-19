package com.cg.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.entity.Employee;
import com.cg.entity.LoginDetails;
import com.cg.repository.EmployeeRepository;
import com.cg.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestEmployee {
	@Autowired
	EmployeeService eService;

	@MockBean
	EmployeeRepository eRepo;

	@Test
	@Order(1)
	public void testAddEmployee() {

		LoginDetails ld = new LoginDetails();
		Employee e = new Employee();

//		ld.setlUsername("akash");
//		ld.setlPassword("1Ab@cdeaa");
//		ld.setlRole("Tester");
//
//		e.setEmpName("akash");
//		e.setEmpPAN("10bxzpn");
//		e.setEmpDesignation("Team Lead");
//		e.setEmpDOJ("05-11-2021");
//		e.setEmpDOB("05-11-2021");
//		e.setEmpDomain("Spring");
//		e.setEmpEmailId("hello234@gmail.com");
//		e.setEmpSalary(80000);
//		e.setUserName("akash");
//		e.setPassword("1Ab@cdeaa");
//		e.setRole("Team Lead");
//		e.setLogindetails(ld);
		// when(eRepo.findAll()).thenReturn(Stream.of(new Employee("")))

	}

	@Test
	@Order(2)
	public void getEmployeesTest() {
		assertEquals(1, eRepo.count());
	}

	@Test
	@Order(3)
	public void updateEmployee() {
		Employee e = eRepo.findById(1).get();
		e.setEmpSalary(20000);
		eRepo.save(e);
		assertNotEquals(80000, eRepo.findById(1).get().getEmpSalary());

	}

	@Test
	@Order(4)
	public void getEmployeeByAll() {
		assertEquals("akash@gmail.com", eService.getEmployeeByAll("akash", "1Ab@cdeaa", "Team Lead").getEmpEmailId());
	}

	@Test
	@Order(5)
	public void deleteEmployeeById() {
		assertEquals("Record Deleted Successfully", eService.deleteEmployee(1));
	}

}
