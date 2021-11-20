package com.mph.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.CustomerDao;
import com.mph.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService
{
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public List<Customer> getCustomerList() {
		
		return customerDao.getCustomerList();
	}

	@Override
	public Customer getCustomer(Customer customer) {

		return customerDao.getCustomer(customer);
	}
	@Override
	public void createCustomer(Customer customer) {
		customerDao.createCustomer(customer);
	}

	@Override
	public List<Customer> updateCustomer(Customer customer) {
		
		return customerDao.updateCustomer(customer);
	}

	@Override
	public List<Customer> deleteCustomer(int customerid) {
		
		return customerDao.deleteCustomer(customerid);
	}

	@Override
	public Customer getCustomerById(int customerid){
		
		return customerDao.getCustomerById(customerid);
	}

	@Override
	public List<Customer> searchCustomerById(int customerid) {
		
		return customerDao.searchCustomerById(customerid);
	}
	
}