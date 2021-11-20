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
import com.mph.entity.Venue;

@Repository
public class VenueDaoImpl implements VenueDao{

	@Autowired
	private SessionFactory sessionFactory;
	

	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Venue> getVenueList() {
		Query qry = getSession().createQuery("from Venue");
		List<Venue> venlist = qry.list();
		return venlist;
	}

	

	@Override
	public void createVenue(Venue venue) 
	{
		getSession().saveOrUpdate(venue);
		System.out.println("Venue Stored Successfully :)");
		
	}

	@Override
	public List<Venue> updateVenue(Venue venue) {
		Query qry = getSession().createQuery("update Venue set venuename=:vnam,venueplace=:vplace,contno=:cno where venueid=:vid");
		qry.setParameter("vnam", venue.getVenuename());
		qry.setParameter("vplace", venue.getVenueplace());
		qry.setParameter("cno", venue.getContno());
		qry.setParameter("vid", venue.getVenueid());
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Update is successful !!!");
		}
		return getVenueList();
	}

	@Override
	public List<Venue> deleteVenue(int venueid) {
		Query qry = getSession().createQuery("delete Venue where venueid=:vid");		
		qry.setParameter("vid", venueid);		
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + venueid + "successfully !!!");
		}
		return getVenueList();
	}




}