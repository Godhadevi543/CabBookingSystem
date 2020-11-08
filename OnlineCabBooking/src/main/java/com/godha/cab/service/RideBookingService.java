package com.godha.cab.service;

import com.godha.cab.dto.RideBooking;

//interface is a reference type and is a collection of abstract methods but not its implementation
public interface RideBookingService {
	
	/*
	 * Author: Godha Devi
	 * Method: bookRide- this method is called when customer wants to book a cab
	 */
	public String bookRide(RideBooking rideBooking);

}
