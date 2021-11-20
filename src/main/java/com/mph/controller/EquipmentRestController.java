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

import com.mph.entity.Equipment;
import com.mph.service.EquipmentService;


@RestController
@RequestMapping(value="/equipment")
@CrossOrigin(origins = { "*" }, methods = {  RequestMethod.GET,
		RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*")
public class EquipmentRestController
{
	@Autowired
	EquipmentService equipmentService;
	
	private static final Logger logger = Logger.getLogger("equipmentRestController.class");

	@GetMapping("/allequipment")
	public ResponseEntity<List<Equipment>> allEquipment() 
	{
		logger.info("GETTING HTTP REQUEST FROM ANGULAR APPLICATION TO LIST Equipment");
		System.out.println(logger.getName() + "   " + logger.getLevel());

		PropertyConfigurator.configure(CustomerRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Log4 j configuration is SUCCESSFUL");
		List<Equipment> eqlist = equipmentService.getEquipmentList();
		System.out.println(eqlist);
		if (eqlist.isEmpty()) 
		{
			return new ResponseEntity<List<Equipment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Equipment>>(eqlist, HttpStatus.OK);
		
	}
	@PostMapping("/createequipment")
	public Equipment createEquipment(@RequestBody Equipment equipment) 
	{
		equipmentService.createEquipment(equipment);
		return equipment;
	}
	@PutMapping("/updateequipment")
	public ResponseEntity<List<Equipment>> updateEquipment(@RequestBody Equipment equipment) {
		System.out.println("Update Rest () " + equipment);
		List<Equipment> ueqlist = equipmentService.updateEquipment(equipment);
		System.out.println(ueqlist);
		if (ueqlist.isEmpty()) {
			return new ResponseEntity<List<Equipment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Equipment>>(ueqlist, HttpStatus.OK);
	}
	@DeleteMapping("/deleteequipment/{eqid}")
	public ResponseEntity<List<Equipment>> deleteEquipment(@PathVariable("eqid") int equipmentid) {
		List<Equipment> deqlist = equipmentService.deleteEquipment(equipmentid);
		System.out.println(deqlist);
		if (deqlist.isEmpty()) {
			return new ResponseEntity<List<Equipment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Equipment>>(deqlist, HttpStatus.OK);
	}


}
