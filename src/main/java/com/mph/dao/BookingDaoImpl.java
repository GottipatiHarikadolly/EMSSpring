package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Booking;
import com.mph.entity.Customer;

@Repository
public class BookingDaoImpl implements BookingDao{

	@Autowired
	private SessionFactory sessionFactory;
	

	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Booking> getBookingList() {
		Query qry = getSession().createQuery("from Booking");
		List<Booking> bolist = qry.list();
		return bolist;
	}


	@Override
	public void createBooking(Booking booking) 
	{
		getSession().saveOrUpdate(booking);
		System.out.println("Booking Stored Successfully :)");
		
	}

	@Override
	public List<Booking> deleteBooking(int bookingid) {
		Query qry = getSession().createQuery("delete Booking where bookingid=:bid");		
		qry.setParameter("bid", bookingid);		
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + bookingid + "successfully !!!");
		}
		return getBookingList();
	}




}