package com.mph.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Booking 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingid;
	private String selectevent;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column
	@Temporal(TemporalType.DATE)
	private Date eventdate;
	private String selectvenue;
	private String selectfoodname;
	private String selectequipmentname;
	@OneToOne
	@JoinColumn(name = "CUSTOMERID")
	private Customer customer;
	public Booking() 
	{
		super();
	}
	public Booking(int bookingid, String selectevent, Date eventDate, String selectvenue, String selectfoodname,
			String selectequipmentname, Customer customer) {
		super();
		this.bookingid = bookingid;
		this.selectevent = selectevent;
		this.eventdate = eventDate;
		this.selectvenue = selectvenue;
		this.selectfoodname = selectfoodname;
		this.selectequipmentname = selectequipmentname;
		this.customer = customer;
	}
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public String getSelectevent() {
		return selectevent;
	}
	public void setSelectevent(String selectevent) {
		this.selectevent = selectevent;
	}
	public Date getEventdate() {
		return eventdate;
	}
	public void setEventDate(Date eventdate) {
		this.eventdate = eventdate;
	}
	public String getSelectvenue() {
		return selectvenue;
	}
	public void setSelectvenue(String selectvenue) {
		this.selectvenue = selectvenue;
	}
	public String getSelectfoodname() {
		return selectfoodname;
	}
	public void setSelectfoodname(String selectfoodname) {
		this.selectfoodname = selectfoodname;
	}
	public String getSelectequipmentname() {
		return selectequipmentname;
	}
	public void setSelectequipmentname(String selectequipmentname) {
		this.selectequipmentname = selectequipmentname;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", selectevent=" + selectevent + ", eventDate=" + eventdate
				+ ", selectvenue=" + selectvenue + ", selectfoodname=" + selectfoodname + ", selectequipmentname="
				+ selectequipmentname + ", customer=" + customer + "]";
	}
	
	
    
	
	
	
	

}
