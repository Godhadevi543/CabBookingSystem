package com.godha.cab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godha.cab.dto.Driver;
import com.godha.cab.repository.DriverRepository;

@Service //class that provides business services
public class DriverServiceImpl implements DriverService{
	
	@Autowired
	private DriverRepository driverRepository;
	
	/*
	 * Author: Likitha Reddy
	 * Method: driverLogin()- this method is implemented when driver wants to login
	 * Return type: Returns string which gives login response
	 * Parameter: we'll pass validated driver object which contains all the necessary attributes.
	 * Description: In this method, we'll validate the driver login credentials
	 */
	
	
	public String driverLogin(Driver driver)
	{
		if(driverRepository.existsByUsername(driver.getUsername()) && driverRepository.existsByPassword(driver.getPassword()))
		{
			return "Login Successfull!!!";		
		}
		return "Invalid";
	}
	
	/*
	 * Author: Likitha Reddy
	 * Method: driverResponse()- this method is implemented when driver gives response to customer
	 * Return type: Returns string which gives driver response
	 * Description: In this method, we'll return the driver response to the customer
	 */
	
	public String driverResponse()
	{
		String driverResponse="Booking Accepted";
		return driverResponse;
	}
	

}
