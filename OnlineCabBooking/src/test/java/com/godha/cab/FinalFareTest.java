package com.godha.cab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.godha.cab.service.CustomerServiceImpl;

/*
 * Author: Godha Devi
 * Annotations: @Autowired
 *              @Test
 * Description: This class will create test cases for final fare              
 */

//Annotation that can be specified on a test class that runs Spring Boot based tests
@SpringBootTest
public class FinalFareTest {
	
	
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	// used to signal that the annotated method is a test method
	 @Test
	    void testFinalFare()
	    {
	        assertEquals(17000.0, customerServiceImpl.finalFare(), "Final Fare is not correct" );
	    }
	
	
	
}
