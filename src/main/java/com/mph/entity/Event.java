package com.mph.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Event
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eventid;
	@Column
	private String eventname;

	public Event()
	{
		super();
	}
	public Event(int eventid, String eventname) {
		super();
		this.eventid = eventid;
		this.eventname = eventname;
	}
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	
	@Override
	public String toString() 
	{
		return "Event [eventid=" + eventid + ", eventname=" + eventname  +"]";
	}
	
	
	
	
	

}
