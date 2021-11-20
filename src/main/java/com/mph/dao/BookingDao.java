package com.mph.dao;

import java.util.List;

import com.mph.entity.Booking;

public interface BookingDao {

	public List<Booking> getBookingList();

	public void createBooking(Booking booking);

	public List<Booking> deleteBooking(int bookingid);

}
