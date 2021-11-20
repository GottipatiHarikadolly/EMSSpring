package com.mph.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mph.entity.Event;

@Repository
public class EventDaoImpl implements EventDao
{
	@Autowired
	private SessionFactory sessionFactory;
	

	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Event> getEventList() 
	{
		Query qry = getSession().createQuery("from Event");
		List<Event> evtlist = qry.list();
		return evtlist;
	}
	
	@Override
	public void createEvent(Event event) 
	{
		getSession().saveOrUpdate(event);
		System.out.println("Event Stored Successfully :)");
		
	}
	@Override
	public List<Event> deleteEvent(int eventid) {
		Query qry = getSession().createQuery("delete Event where eventid=:eid");		
		qry.setParameter("eid", eventid);		
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + eventid + "successfully !!!");
		}
		return getEventList();
	}
	

}
