package com.mph.dao;

import java.util.List;

import com.mph.entity.Event;

public interface EventDao {

	public List<Event> getEventList();

	public void createEvent(Event event);

	public List<Event> deleteEvent(int eventid);

}
