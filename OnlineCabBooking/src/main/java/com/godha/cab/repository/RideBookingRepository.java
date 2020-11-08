package com.godha.cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godha.cab.dto.RideBooking;

/*
 * CrudRepository mainly provides CRUD functions.
 * PagingAndSortingRepository provides methods to do pagination and sorting records.
 *  JpaRepository will have all the functions of CrudRepository and PagingAndSortingRepository. 
 *  So if you don't need the repository to have the functions provided by JpaRepository and PagingAndSortingRepository , use CrudRepository.
 */

//interface is a reference type and is a collection of abstract methods
public interface RideBookingRepository extends  JpaRepository<RideBooking, Integer>{

}
