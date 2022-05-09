package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.LoginDetails;

public interface LoginDetailsRepository extends JpaRepository<LoginDetails, Integer> {

	boolean existsBylUserName(String lUsername);

	public LoginDetails findBylRole(String lRole);

}