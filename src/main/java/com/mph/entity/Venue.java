package com.mph.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venue 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int venueid;
	@Column
	private String venuename;
	@Column
	private String venueplace;
	@Column 
	private long contno;
	
	public Venue() {
		super();
	
	}
	public Venue(int venueid, String venuename, String venueplace, long contno) {
		super();
		this.venueid = venueid;
		this.venuename = venuename;
		this.venueplace = venueplace;
		this.contno = contno;
	}
	public int getVenueid() {
		return venueid;
	}
	public void setVenueid(int venueid) {
		this.venueid = venueid;
	}
	public String getVenuename() {
		return venuename;
	}
	public void setVenuename(String venuename) {
		this.venuename = venuename;
	}
	public String getVenueplace() {
		return venueplace;
	}
	public void setVenueplace(String venueplace) {
		this.venueplace = venueplace;
	}
	public long getContno() {
		return contno;
	}
	public void setContno(long contno) {
		this.contno = contno;
	}
	@Override
	public String toString() 
	{
		return "Venue [venueid=" + venueid + ", venuename=" + venuename + ", venueplace=" + venueplace + ", contactno="
				+ contno + "]";
	}
	
	
	
	
	
	
	}



	
	


	
	
	
	
	
	


