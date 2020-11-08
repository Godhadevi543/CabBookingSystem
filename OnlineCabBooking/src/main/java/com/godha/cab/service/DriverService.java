package com.godha.cab.service;

import com.godha.cab.dto.Driver;

//interface is a reference type and is a collection of abstract methods but not its implementation
public interface DriverService {
		
	/*
	 * Author: Likitha Reddy
	 * Method: driverLogin()- this method is implemented when driver wants to login
	 */
	public String driverLogin(Driver driver);
	
	/*
	 * Author: Likitha Reddy
	 * Method: driverResponse()- this method is implemented when driver gives response to customer
	 */
	public String driverResponse();
}
