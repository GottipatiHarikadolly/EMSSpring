package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;
	

	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Customer> getCustomerList() {
		Query qry = getSession().createQuery("from Customer");
		List<Customer> cstrlist = qry.list();
		return cstrlist;
	}

	@Override
	public Customer getCustomer(Customer customer)
	{
		Criteria c = getSession().createCriteria(Customer.class);
		c.add(Restrictions.eq("emailid", customer.getEmailid()));
		c.add(Restrictions.eq("password", customer.getPassword()));
		Customer cstr = (Customer)c.uniqueResult();
		return cstr;
	}

	@Override
	public void createCustomer(Customer customer) 
	{
		getSession().saveOrUpdate(customer);
		System.out.println("Customer Stored Successfully :)");
		
	}

	@Override
	public List<Customer> updateCustomer(Customer customer) {
		Query qry = getSession().createQuery("update Customer set customername=:nam,contactno=:cno,emailid=:email,password=:pass where customerid=:cid");
		qry.setParameter("nam", customer.getCustomername());
		qry.setParameter("cno", customer.getContactno());
		qry.setParameter("email", customer.getEmailid());
		qry.setParameter("pass", customer.getPassword());
		qry.setParameter("cid", customer.getCustomerid());
		
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Update is successful !!!");
		}
		return getCustomerList();
	}

	@Override
	public List<Customer> deleteCustomer(int customerid) {
		Query qry = getSession().createQuery("delete Customer where customerid=:cid");		
		qry.setParameter("cid", customerid);		
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + customerid + "successfully !!!");
		}
		return getCustomerList();
	}

	@Override
	public Customer getCustomerId(int customerid) 
	{
		Query query = getSession().createQuery("from Customer cstr where customerid=:cid");
		query.setParameter("cid", customerid);
		Customer cstrlist =(Customer) query.uniqueResult();
		System.out.println(cstrlist);
		return cstrlist; 
	}
	@Override
	public Customer getCustomerById(int customerid) {
		Query query = getSession().createQuery("from Customer cstr where customerid=:cid");
		query.setParameter("cid", customerid);
		Customer cstrlist =(Customer) query.uniqueResult();
		System.out.println(cstrlist);
		return cstrlist; 
	}

	@Override
	public List<Customer> searchCustomerById(int customerid) {
		Query query = getSession().createQuery("from Customer cstr where customerid=:cid");
		query.setParameter("cid", customerid);
		List<Customer> cstrlist =query.list();
		System.out.println(cstrlist);
		return cstrlist; 
	}




}