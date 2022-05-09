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
//import com.cg.entity.LoginDetails;
//import com.cg.repository.LoginDetailsRepository;
//import com.cg.service.LoginDetailsService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class TestLoginDetails {
//
//	@Autowired
//	LoginDetailsService loginDetailsService;
//
//	@MockBean
//	LoginDetailsRepository loginDetailsRepo;
//
//	String ans;
//
//	LoginDetails ld;
//
//	int id;
//	String lUserName;
//	String lPassword;
//	String lRole;
//
//	@BeforeEach
//	void setup() {
//		id = 100;
//		lUserName = "anmol2";
//		lPassword = "@nmolDubey12";
//		lRole = "Developer2";
//		ld = new LoginDetails(100, lUserName, lPassword, lRole);
//		loginDetailsRepo.save(ld);
//		ans = "LoginDetails [id=" + id + ", lUserName=" + lUserName + ", lPassword=" + lPassword + ", lRole=" + lRole
//				+ "]";
//	}
//
//	@Test
//	@Order(1)
//	public void testAddDetails() {
//		when(loginDetailsRepo.save(ld)).thenReturn(ld);
//		assertEquals(ans, loginDetailsService.addLoginDetailsTest(ld).toString());
//	}
//
//	@Test
//	@Order(2)
//	public void testFindByRole() {
//		when(loginDetailsRepo.findBylRole(lRole)).thenReturn(ld);
//		assertEquals(ans, loginDetailsService.findByLRole(ld).toString());
//	}
//
//	@Test
//	@Order(3)
//	public void testUpdateLoginDetail() {
//		when(loginDetailsRepo.save(ld)).thenReturn(ld);
//		when(loginDetailsRepo.findBylRole(lRole)).thenReturn(ld);
//		ld.setlRole("Manager");
//		when(loginDetailsRepo.save(ld)).thenReturn(ld);
//		String test3 = "LoginDetails [id=" + id + ", lUserName=" + lUserName + ", lPassword=" + lPassword + ", lRole="
//				+ "Manager" + "]";
//		assertEquals(test3, loginDetailsService.updateLoginDetails(ld).toString());
//	}
//
//	@Test
//	@Order(4)
//	public void testDeleteLoginDetails() {
//		loginDetailsService.deleteLoginDetails(ld);
//		verify(loginDetailsRepo, times(1)).delete(ld);
//	}
//}
