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
import com.mph.entity.FoodItem;
import com.mph.entity.FoodItem;
import com.mph.service.EventService;
import com.mph.service.FoodItemService;
import com.mph.service.VenueService;

@RestController
@RequestMapping(value="/fooditem")
@CrossOrigin(origins = { "*" }, methods = {  RequestMethod.GET,
		RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*")
public class FoodItemRestController
{
	@Autowired
	FoodItemService fooditemService;
	
	private static final Logger logger = Logger.getLogger("FoodItemRestController.class");

	@GetMapping("/allfooditem")
	public ResponseEntity<List<FoodItem>> allFoodItem() 
	{
		logger.info("GETTING HTTP REQUEST FROM ANGULAR APPLICATION TO LIST Customer");
		System.out.println(logger.getName() + "   " + logger.getLevel());

		PropertyConfigurator.configure(CustomerRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Log4 j configuration is SUCCESSFUL");
		List<FoodItem> flist = fooditemService.getFoodItemList();
		System.out.println(flist);
		if (flist.isEmpty()) 
		{
			return new ResponseEntity<List<FoodItem>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FoodItem>>(flist, HttpStatus.OK);
		
	}
	@PostMapping("/createfooditem")
	public FoodItem createFoodItem(@RequestBody FoodItem fooditem) 
	{
		fooditemService.createFoodItem(fooditem);
		return fooditem;
	}
	@PutMapping("/updatfooditem")
	public ResponseEntity<List<FoodItem>> updateFoodItem(@RequestBody FoodItem fooditem) {
		System.out.println("Update Rest () " + fooditem);
		List<FoodItem> uflist = fooditemService.updateFoodItem(fooditem);
		System.out.println(uflist);
		if (uflist.isEmpty()) {
			return new ResponseEntity<List<FoodItem>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FoodItem>>(uflist, HttpStatus.OK);
	}
	@DeleteMapping("/deletefooditem/{foitid}")
	public ResponseEntity<List<FoodItem>> deleteFoodItem(@PathVariable("foitid") int fooditemid) {
		List<FoodItem> dflist = fooditemService.deleteFoodItem(fooditemid);
		System.out.println(dflist);
		if (dflist.isEmpty()) {
			return new ResponseEntity<List<FoodItem>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FoodItem>>(dflist, HttpStatus.OK);
	}


}
