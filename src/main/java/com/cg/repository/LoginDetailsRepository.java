package com.cg.repository;



import org.springframework.data.jpa.repository.JpaRepository;



import com.cg.entity.Employee;
import com.cg.entity.LoginDetails;



public interface LoginDetailsRepository extends JpaRepository<LoginDetails,Integer> {

	boolean existsBylUserName(String lUsername);

}