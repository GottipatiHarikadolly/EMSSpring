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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.mph.entity.Event;
import com.mph.service.EventService;

@RestController
@RequestMapping(value="/event")
@CrossOrigin(origins = { "*" }, methods = {  RequestMethod.GET,
		RequestMethod.POST, RequestMethod.DELETE }, allowedHeaders = "*")
public class EventRestController 
{
	@Autowired
	EventService eventService;
	
	private static final Logger logger = Logger.getLogger("EventRestController.class");

	@GetMapping("/allevent")
	public ResponseEntity<List<Event>> allEvent() 
	{
		logger.info("GETTING HTTP REQUEST FROM ANGULAR APPLICATION TO LIST Customer");
		System.out.println(logger.getName() + "   " + logger.getLevel());

		PropertyConfigurator.configure(CustomerRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Log4 j configuration is SUCCESSFUL");
		List<Event> elist = eventService.getEventList();
		System.out.println(elist);
		if (elist.isEmpty()) 
		{
			return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Event>>(elist, HttpStatus.OK);
		
	}
	@PostMapping("/createevent")
	public Event createEvent(@RequestBody Event event) 
	{
		eventService.createEvent(event);
		return event;
	}
	@DeleteMapping("/deleteevent/{evtid}")
	public ResponseEntity<List<Event>> deleteEvent(@PathVariable("evtid") int eventid) {
		List<Event> delist = eventService.deleteEvent(eventid);
		System.out.println(delist);
		if (delist.isEmpty()) {
			return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Event>>(delist, HttpStatus.OK);
	}

	

}
