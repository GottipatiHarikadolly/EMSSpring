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

import com.mph.entity.Customer;
import com.mph.entity.Event;
import com.mph.entity.Venue;
import com.mph.service.EventService;
import com.mph.service.VenueService;

@RestController
@RequestMapping(value="/venue")
@CrossOrigin(origins = { "*" }, methods = {  RequestMethod.GET,
		RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*")
public class VenueRestController
{
	@Autowired
	VenueService venueService;
	
	private static final Logger logger = Logger.getLogger("VenueRestController.class");

	@GetMapping("/allVenue")
	public ResponseEntity<List<Venue>> allVenue() 
	{
		logger.info("GETTING HTTP REQUEST FROM ANGULAR APPLICATION TO LIST Customer");
		System.out.println(logger.getName() + "   " + logger.getLevel());

		PropertyConfigurator.configure(CustomerRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Log4 j configuration is SUCCESSFUL");
		List<Venue> vlist = venueService.getVenueList();
		System.out.println(vlist);
		if (vlist.isEmpty()) 
		{
			return new ResponseEntity<List<Venue>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Venue>>(vlist, HttpStatus.OK);
		
	}
	@PostMapping("/createVenue")
	public Venue createVenue(@RequestBody Venue venue) 
	{
		venueService.createVenue(venue);
		return venue;
	}
	@PutMapping("/updatevenue")
	public ResponseEntity<List<Venue>> updateVenue(@RequestBody Venue venue) {
		System.out.println("Update Rest () " + venue);
		List<Venue> uvlist = venueService.updateVenue(venue);
		System.out.println(uvlist);
		if (uvlist.isEmpty()) {
			return new ResponseEntity<List<Venue>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Venue>>(uvlist, HttpStatus.OK);
	}
	@DeleteMapping("/deleteVenue/{venid}")
	public ResponseEntity<List<Venue>> deleteVenue(@PathVariable("venid") int venueid) {
		List<Venue> dvlist = venueService.deleteVenue(venueid);
		System.out.println(dvlist);
		if (dvlist.isEmpty()) {
			return new ResponseEntity<List<Venue>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Venue>>(dvlist, HttpStatus.OK);
	}


}
