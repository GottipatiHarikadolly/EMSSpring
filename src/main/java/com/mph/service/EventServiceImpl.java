package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.EventDao;
import com.mph.entity.Event;

@Service
@Transactional
public class EventServiceImpl implements EventService
{
	@Autowired
	EventDao eventDao;
	
	public List<Event> getEventList()
	{
		return eventDao.getEventList();
	}
	

	public void createEvent(Event event)
	{
		 eventDao.createEvent(event);
		
	}

	public List<Event> deleteEvent(int eventid)
	{
		return eventDao.deleteEvent(eventid);
	}
	}
