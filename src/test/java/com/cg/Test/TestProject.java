//package com.cg.Test;
//
//import static org.junit.Assert.assertEquals;
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
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.cg.entity.Project;
//import com.cg.repository.ProjectRepository;
//import com.cg.service.ProjectService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class TestProject {
//	@Autowired
//	ProjectService pService;
//
//	@MockBean
//	ProjectRepository pRepo;
//
//	String ans;
//
//	Project p;
//
//	int projectCode;
//	String projectDescription;
//	LocalDate startDate;
//	LocalDate endDate;
//
//	@BeforeEach
//	void setup() {
//		projectCode = 500;
//		projectDescription = "Employee Expense System";
//		startDate = LocalDate.parse("31-10-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//		endDate = LocalDate.parse("12-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//		p = new Project(projectCode, projectDescription, startDate, endDate);
//		ans = "Project [projectCode=" + projectCode + ", projectDescription=" + projectDescription + ", startDate="
//				+ startDate + ", endDate=" + endDate + "]";
//	}
//
//	@Test
//	@Order(1)
//	public void testAddProject() {
//		when(pRepo.save(p)).thenReturn(p);
//		assertEquals(ans, pService.addProjectTest(p).toString());
//	}
//
//	@Test
//	@Order(2)
//	public void testGetProjectDescription() {
//		when(pRepo.findByProjectDescription(projectDescription)).thenReturn(p);
//		assertEquals(ans, pService.getProjectDescription(p).toString());
//	}
//
//	@Test
//	@Order(3)
//	public void testUpdateProject() {
//		when(pRepo.save(p)).thenReturn(p);
//		when(pRepo.findByProjectDescription(projectDescription)).thenReturn(p);
//		p.setProjectDescription("Employee Expense System 2");
//		when(pRepo.save(p)).thenReturn(p);
//		String test3 = "Project [projectCode=" + projectCode + ", projectDescription=" + "Employee Expense System 2"
//				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
//		assertEquals(test3, pService.testUpdateProjectFunction(p).toString());
//	}
//
//	@Test
//	@Order(4)
//	public void testDeleteProject() {
//		pService.deleteProject(p);
//		verify(pRepo, times(1)).delete(p);
//	}
//}
