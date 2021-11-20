package com.mph.controller;

import java.util.List;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Booking;
import com.mph.service.BookingService;



@RestController
@RequestMapping(value="/booking")
@CrossOrigin(origins = { "*" }, methods = {  RequestMethod.GET,
		RequestMethod.POST, RequestMethod.DELETE }, allowedHeaders = "*")
public class BookingRestController
{
	@Autowired
	BookingService bookingService;
	
	private static final Logger logger = Logger.getLogger("BookingRestController.class");

	@GetMapping("/allbooking")
	public ResponseEntity<List<Booking>> allBooking() 
	{
		logger.info("GETTING HTTP REQUEST FROM ANGULAR APPLICATION TO LIST Booking");
		System.out.println(logger.getName() + "   " + logger.getLevel());

		PropertyConfigurator.configure(CustomerRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Log4 j configuration is SUCCESSFUL");
		List<Booking> blist = bookingService.getBookingList();
		System.out.println(blist);
		if (blist.isEmpty()) 
		{
			return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Booking>>(blist, HttpStatus.OK);
		
	}
	@PostMapping("/createbooking")
	public Booking createBooking(@RequestBody Booking booking) 
	{
	    bookingService.createBooking(booking);
		return booking;
	}
	@DeleteMapping("/deletebooking/{boid}")
	public ResponseEntity<List<Booking>> deleteBooking(@PathVariable("boid") int bookingid) {
		List<Booking> dblist = bookingService.deleteBooking(bookingid);
		System.out.println(dblist);
		if (dblist.isEmpty()) 
		{
			return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Booking>>(dblist, HttpStatus.OK);
	}


}
