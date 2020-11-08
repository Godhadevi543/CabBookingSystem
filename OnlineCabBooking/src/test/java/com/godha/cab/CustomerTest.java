package com.godha.cab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.godha.cab.dto.Customer;
import com.godha.cab.repository.CustomerRepository;
import com.godha.cab.service.CustomerServiceImpl;

     /*
	 * Author: Godha Devi
	 * Annotations: @Autowired
	 *              @MockBean
	 *              @Before
	 *              @Test
	 *              @After
	 * Description: This class will create test cases for customer login details like username and password              
	 */

//Annotation that can be specified on a test class that runs Spring Boot based tests
@SpringBootTest
public class CustomerTest {
	
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	//Annotation that can be used to add mocks to a Spring 
	//mock is an object which tests the dummy data that we pass
	@MockBean
	CustomerRepository customerRepository;
	
	Customer customer=new Customer();
	
	
	//causes that method to be run before the Test method
		@Before
		public void beforeTest()
		{
			customer.setUsername("godhadevi");
			customer.setPassword("Bandari@123");
		}
		
		// used to signal that the annotated method is a test method
		@Test
		public void loginTest()
		{
			//The Mockito library enables mock creation, verification.
			Mockito.when(customerRepository.existsByUsername("godhadevi")).thenReturn(true);
			Mockito.when(customerRepository.existsByPassword("Bandari@123")).thenReturn(true);
			assertEquals("Invalid", customerServiceImpl.customerLogin(customer));
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
		customer.setUsername("godhadevi");
		customer.setPassword("godhai@123");
	}
	
	// used to signal that the annotated method is a test method
	@Test
	public void loginTest1()
	{
		//The Mockito library enables mock creation, verification.
		Mockito.when(customerRepository.existsByUsername("godhadevi")).thenReturn(true);
		Mockito.when(customerRepository.existsByPassword("godhai@123")).thenReturn(false);
		assertEquals("Invalid", customerServiceImpl.customerLogin(customer));
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
		customer.setUsername("godha");
		customer.setPassword("Bandari@123");
	}
	
	// used to signal that the annotated method is a test method
	@Test
	public void loginTest2()
	{
		//The Mockito library enables mock creation, verification.
		Mockito.when(customerRepository.existsByUsername("godha")).thenReturn(false);
		Mockito.when(customerRepository.existsByPassword("Bandari@123")).thenReturn(true);
		assertEquals("Invalid", customerServiceImpl.customerLogin(customer));
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
		customer.setUsername("godha");
		customer.setPassword("Bandari@1");
	}
	
	// used to signal that the annotated method is a test method
	@Test
	public void loginTest3()
	{
		//The Mockito library enables mock creation, verification.
		Mockito.when(customerRepository.existsByUsername("godha")).thenReturn(false);
		Mockito.when(customerRepository.existsByPassword("Bandari@1")).thenReturn(false);
		assertEquals("Invalid", customerServiceImpl.customerLogin(customer));
	}
   
	//If you allocate external resources in a Before method you need to release them after the test runs
	@After
	public void afterTest3()
	{
		System.gc();
	}
}
