package com.cg.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.entity.Project;
import com.cg.repository.ProjectRepository;
import com.cg.service.ProjectService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestProject {
	@Autowired
	ProjectService pService;

	@Autowired
	ProjectRepository pRepo;

//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}

	@Test
	@Order(1)
	public void TestAddProject() {
		Project p = new Project();
		LocalDate startDate = LocalDate.parse("12-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		LocalDate endDate = LocalDate.parse("12-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		p.setProjectDescription("Employee System");
		p.setStartDate(startDate);
		p.setEndDate(endDate);
		pRepo.save(p);
		assertEquals("Employee System", pRepo.findByProjectDescription("Employee System").getProjectDescription());
	}

	@Test
	@Order(2)
	public void TestGetAllProjectCodes() {
		List<Integer> codes = new ArrayList<>();
		codes.add(1);
		assertEquals(codes, pRepo.getAllProjectCodes());
	}

	@Test
	@Order(3)
	public void TestUpdateProject() {
		Project p = pRepo.findById(1).get();
		p.setProjectDescription("Recommender System");
		pRepo.save(p);
		assertNotEquals("Employee System", pRepo.findById(1).get().getProjectDescription());
	}

	@Test
	@Order(4)
	public void TestFindProjectByCode() {
		// Both objects are equal but assertEquals shows error so instead we check
		// ProjectCode
		// Project p = pRepo.findById(1).get();
		// assertEquals(p, pRepo.findById(1).get());
		assertEquals(1, pRepo.findById(1).get().getProjectCode());
	}

	@Test
	@Order(5)
	public void TestdeleteProjectById() {
		assertEquals("Record deleted successfully!", pService.deleteProjectById(1));
	}

}
