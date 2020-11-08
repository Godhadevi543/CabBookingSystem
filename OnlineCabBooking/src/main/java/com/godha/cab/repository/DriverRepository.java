package com.godha.cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godha.cab.dto.Driver;

//interface is a reference type and is a collection of abstract methods
public interface DriverRepository extends JpaRepository<Driver, Integer>{
	
	public boolean existsByPassword(String password);

	public boolean existsByUsername(String username);
	
	public boolean existsByResponse(String response);

}
