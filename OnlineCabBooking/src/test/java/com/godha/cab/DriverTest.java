package com.godha.cab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.godha.cab.dto.Driver;
import com.godha.cab.repository.DriverRepository;
import com.godha.cab.service.DriverServiceImpl;

/*
 * Author: Godha Devi
 * Annotations: @Autowired
 *              @MockBean
 *              @Before
 *              @Test
 *              @After
 * Description: This class will create test cases for driver login details like username and password              
 */

//Annotation that can be specified on a test class that runs Spring Boot based tests
@SpringBootTest
public class DriverTest {
	
	@Autowired
	DriverServiceImpl driverServiceImpl;
	
	/*Annotation that can be used to add mocks to a Spring 
	*mock is an object which tests the dummy data that we pass
	*/
	@MockBean
	DriverRepository driverRepository;
	
	Driver driver=new Driver();

	//causes that method to be run before the Test method
		@Before
		public void beforeTest()
		{
			driver.setUsername("ajay"); 
			driver.setPassword("Ajay@123"); 
		}
		
		// used to signal that the annotated method is a test method
		@Test
		public void loginTest()
		{
			//The Mockito library enables mock creation, verification.
			Mockito.when(driverRepository.existsByUsername("ajay")).thenReturn(true);
			Mockito.when(driverRepository.existsByPassword("Ajay@123")).thenReturn(true);
			assertEquals("Invalid", driverServiceImpl.driverLogin(driver));
		}
		
		//If you allocate external resources in a Before method you need to release them after the test runs
		@After
		public void afterTest()
		{
			/*
			 * gc() method runs the garbage collector. 
			 * Calling this suggests that the JVM effort towards recycling unused objects 
			 * in order to make the memory they currently occupy available for quick reuse.
			 */
			System.gc();
		}

		
	//causes that method to be run before the Test method
	@Before
	public void beforeTest1()
	{
		driver.setUsername("ajay"); 
		driver.setPassword("Ajay@1"); 
	}
	
	// used to signal that the annotated method is a test method
	@Test
	public void loginTest1()
	{
		//The Mockito library enables mock creation, verification.
		Mockito.when(driverRepository.existsByUsername("ajay")).thenReturn(true);
		Mockito.when(driverRepository.existsByPassword("Ajay@1")).thenReturn(false);
		assertEquals("Invalid", driverServiceImpl.driverLogin(driver));
	}
	
	//If you allocate external resources in a Before method you need to release them after the test runs
	@After
	public void afterTest1()
	{
		/*
		 * gc() method runs the garbage collector. 
		 * Calling this suggests that the JVM effort towards recycling unused objects 
		 * in order to make the memory they currently occupy available for quick reuse.
		 */
		System.gc();
	}
	
	//causes that method to be run before the Test method
	@Before
	public void beforeTest2()
	{
		driver.setUsername("aj"); 
		driver.setPassword("Ajay@123");
	}
	
	// used to signal that the annotated method is a test method
	@Test
	public void loginTest2()
	{ 
		//The Mockito library enables mock creation, verification.
		Mockito.when(driverRepository.existsByUsername("aj")).thenReturn(false);
		Mockito.when(driverRepository.existsByPassword("Ajay@123")).thenReturn(true);
		assertEquals("Invalid", driverServiceImpl.driverLogin(driver));
	}
	
	//If you allocate external resources in a Before method you need to release them after the test runs
	@After
	public void afterTest2()
	{
		System.gc();
	}
	
	//causes that method to be run before the Test method
	@Before
	public void beforeTest3()
	{
		driver.setUsername("aj"); 
		driver.setPassword("Ajay@1"); 
	}
	
	// used to signal that the annotated method is a test method
	@Test
	public void loginTest3()
	{
		//The Mockito library enables mock creation, verification.
		Mockito.when(driverRepository.existsByUsername("aj")).thenReturn(false);
		Mockito.when(driverRepository.existsByPassword("Ajay@1")).thenReturn(false);
		assertEquals("Invalid", driverServiceImpl.driverLogin(driver));
	}
	
	//If you allocate external resources in a Before method you need to release them after the test runs
	@After
	public void afterTest3()
	{
		System.gc();
	}
}
