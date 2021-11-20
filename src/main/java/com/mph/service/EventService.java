package com.mph.service;

import java.util.List;

import com.mph.entity.Event;

public interface EventService 
{
	public List<Event> getEventList();

	public void createEvent(Event event);

	public List<Event> deleteEvent(int eventid);


}
