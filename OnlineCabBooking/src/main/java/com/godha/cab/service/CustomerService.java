package com.godha.cab.service;

import java.util.ArrayList;

import com.godha.cab.dto.Cab;
import com.godha.cab.dto.Customer;
import com.godha.cab.dto.Driver;
import com.godha.cab.dto.RideBooking;

//interface is a reference type and is a collection of abstract methods but not its implementation
public interface CustomerService  {
		
	/*
	 * Author: Bhavita
	 * Description: contains abstract method called bookingHistoryCustomers() 
	 */
	
	public ArrayList<RideBooking>  bookingHistoryCustomers();
	
	/*
	 * Author: Rishitha
	 * Description: contains abstract method called finalFare()
	 */
	
	public float finalFare();

	/*
	 * Author: Bhavita
	 * Description: contains abstract method called customerLogin() 
	 */
	
	public String customerLogin(Customer customer);
	
	/*
	 * Author: Bhavita
	 * Description: contains abstract method called addCustomer() 
	 */
	
	public String addCustomer(Customer customer);
	
	/*
	 * Author: Rishitha
	 * Description: contains abstract method called cabDetails()
	 */
	
	public ArrayList<Cab> cabDetails();
	
	/*
	 * Author: Rishitha
	 * Description: contains abstract method called driverDetails()
	 */
	
	public ArrayList<Driver> driverDetails();
}