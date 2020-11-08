package com.godha.cab.service;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godha.cab.dto.Cab;
import com.godha.cab.dto.Customer;
import com.godha.cab.dto.Driver;
import com.godha.cab.dto.RideBooking;
import com.godha.cab.repository.CabRepository;
import com.godha.cab.repository.CustomerRepository;
import com.godha.cab.repository.DriverRepository;


@Service //class that provides business services
public class CustomerServiceImpl  implements CustomerService{
		
	@PersistenceContext // to indicate that the EntityManager must be automatically injected
	EntityManager entityManager; // object that manages a set of entities that are defined by a persistence unit.
	//private static Logger myLogger;
	@Autowired // enables you to inject the object dependency implicitly. wiring an object into another(default,byType,byName,constructor)
	private CustomerRepository customerRepository;
	
	@Autowired
	private CabRepository cabRepository;
	@Autowired
	private DriverRepository driverRepository;

	/*
	 * Author: Bhavita
	 * Method: customerLogin()- this method is implemented when customer wants to login
	 * Return type: Returns string which gives login response
	 * Parameter: we'll pass validated customer object which contains all the necessary attributes.
	 * Description: In this method, we'll validate the customer login credentials
	 */
	
	public String customerLogin(Customer customer)
	{
		if(customerRepository.existsByUsername(customer.getUsername()) && customerRepository.existsByPassword(customer.getPassword()))
		{
			return "Login Successfull!!!";		
		}
		return "Invalid";
	}
	
	/*
	 * Author: Bhavita
	 * Method: addCandidate- this method is implemented when we want to add a customer details
	 * Parameter: we'll pass validated customer object which contains all the necessary attributes.
	 * Description: In this method, we'll add customer details by calling customerRepository
	 */
	
	
	public String addCustomer(Customer customer)
	{
		if(customer!=null)
		{
		customerRepository.save(customer);
		return "Customer data is valid";
		}
		return "Customer data is Invalid";
	}

	/*
	 * Author: Bhavita
	 * Method: bookingHistoryCustomers() - this method is implemented when customer wants to get ride booking history details
	 * Return type: Returns ArrayList which includes ride booking history details
	 * Description: In this method, we'll get ride booking history details by writing a query
	 */
	
	
	public ArrayList<RideBooking>  bookingHistoryCustomers()
	{
		/* query is an interface in which we request data from the database
		 * createNamedQuery(name), createNativeQuery(sqlString), createStoredProcedureQuery(procedureName, resultClasses),
		 * createQuery(CriticalQuery)
		 */
		Query query = (Query) entityManager.createQuery("select b from RideBooking b");
		ArrayList<RideBooking> booking=(ArrayList<RideBooking>)query.list();
	    return booking;
	}
	
	/*
	 * Author: Rishitha
	 * Method: getCabDetails- this method is implemented when customer wants to get cab details
	 * Return type: Returns ArrayList which includes Driver details
	 * Description: In this method, we'll get driver details by calling customer service
	 */
	
	
	public ArrayList<Cab> cabDetails()
	{
		return (ArrayList<Cab>) cabRepository.findAll();
	}
	
	/*
	 * Author: Rishitha
	 * Method: getDriverDetails- this method is implemented when customer wants to get cab details
	 * Return type: Returns ArrayList which includes cab details
	 * Description: In this method, we'll get cab details by calling customer service
	 */
	
	
	public ArrayList<Driver> driverDetails()
	{
		return (ArrayList<Driver>) driverRepository.findAll();
	}

	/*
	 * Author: Rishitha
	 * Method: finalFare() - this method is implemented when customer wants to get final fare after the ride
	 * Return type: Returns a float value which is the final fare
	 * Description: In this method, we'll get final fare by performing operations based on the initial fare and kilometers
	 *              that source and destination include
	 */
	
	public float finalFare()
	{
		float kilometers=340f;
		float initialfare=50f;
	    float finalFare=kilometers*initialfare;
		return finalFare;
	}


}
