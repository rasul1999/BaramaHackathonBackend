package com.hackathon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.model.LoginSession;


@Repository
public interface LoginSessionRepository extends CrudRepository<LoginSession, Long>{
	
	public LoginSession findByEmail(String email);

	
}
