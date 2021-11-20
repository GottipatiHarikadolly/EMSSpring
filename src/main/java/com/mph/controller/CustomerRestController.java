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
import com.mph.service.CustomerService;

@RestController
@RequestMapping(value="/customer")
@CrossOrigin(origins = { "*" }, methods = {  RequestMethod.GET,
		RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*")
public class CustomerRestController {

	@Autowired
	CustomerService customerService;
	
	private static final Logger logger = Logger.getLogger("CustomerRestController.class");

	@GetMapping("/allcstr")
	public ResponseEntity<List<Customer>> allCustomer() 
	{
		logger.info("GETTING HTTP REQUEST FROM ANGULAR APPLICATION TO LIST Customer");
		System.out.println(logger.getName() + "   " + logger.getLevel());

		PropertyConfigurator.configure(CustomerRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Log4 j configuration is SUCCESSFUL");
		List<Customer> clist = customerService.getCustomerList();
		System.out.println(clist);
		if (clist.isEmpty()) 
		{
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(clist, HttpStatus.OK);
	}
	@PostMapping("/login")
	public ResponseEntity<Customer> getCustomer(Customer customer) 
	{
		Customer cstr = customerService.getCustomer(customer);
		
		if ( cstr == null) {
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Customer>(cstr, HttpStatus.OK);
		
		
	}
	

	@PostMapping("/createcstr")
	public Customer createCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		return customer;
	}

	@GetMapping("/getcstr/{cstrid}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("cstrid") int customerid) {
		Customer cstr = customerService.getCustomerById(customerid);
		if ( cstr == null) {
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Customer>(cstr, HttpStatus.OK);
	}

	@PutMapping("/updatecstr")
	public ResponseEntity<List<Customer>> updateCustomer(@RequestBody Customer customer) {
		System.out.println("Update Rest () " + customer);
		List<Customer> uclist = customerService.updateCustomer(customer);
		System.out.println(uclist);
		if (uclist.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(uclist, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCustomer/{cstrid}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("cstrid") int customerid) {
		List<Customer> dclist = customerService.deleteCustomer(customerid);
		System.out.println(dclist);
		if (dclist.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(dclist, HttpStatus.OK);
	}
}