package com.godha.cab;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.godha.cab.dto.Cab;
import com.godha.cab.dto.Driver;
import com.godha.cab.repository.CabRepository;
import com.godha.cab.repository.DriverRepository;
import com.godha.cab.service.DriverServiceImpl;

/*
 * Author: Godha Devi
 * Annotations: @Autowired
 *              @MockBean
 *              @Before
 *              @Test
 *              @After
 * Description: This class will create test cases for driver login details.              
 */

//Annotation that can be specified on a test class that runs Spring Boot based tests
@SpringBootTest
public class DriverLoginTest {
	
	@Autowired
	DriverServiceImpl driverServiceImpl;
	
	/*Annotation that can be used to add mocks to a Spring 
	*mock is an object which tests the dummy data that we pass
	*/
	@MockBean
	DriverRepository driverRepository;
	
	@MockBean
	CabRepository cabRepository;
	
	Driver driver=new Driver();
	
	//causes that method to be run before the Test method
	@Before
	public void beforeTest1()
	{
		driver.setDriverid("507");
        driver.setDriverfirstname("Ajay");
        driver.setDriverlastname("Lakavath");
        driver.setContact("2491254937");
        driver.setCabnumber("TS 09 MD 7987");
        driver.setUsername("ajay");
        driver.setPassword("Ajay@123");
	}
	
	// used to signal that the annotated method is a test method
	 @Test
	 public void loginTest() 
	 {
	    when(driverRepository.save(driver)).thenReturn(driver);
	 }
	 
	//If you allocate external resources in a Before method you need to release them after the test runs
	 @After
     public void afterTest2()
	 {
		 /*
			 * gc() method runs the garbage collector. 
			 * Calling this suggests that the JVM effort towards recycling unused objects 
			 * in order to make the memory they currently occupy available for quick reuse.
			 */
		System.gc();
	 }
	 
	// used to signal that the annotated method is a test method
	 @Test
	 public void cabDetailsTest()
	 {
		List<Cab> cab=new ArrayList<Cab>();
		when(cabRepository.findAll()).thenReturn(cab);	
	 }
	 
	// used to signal that the annotated method is a test method
	 @Test
	 public void driverDetailsTest()
	 {
		List<Driver> driver=new ArrayList<Driver>();
		when(driverRepository.findAll()).thenReturn(driver);	
	 }

}
