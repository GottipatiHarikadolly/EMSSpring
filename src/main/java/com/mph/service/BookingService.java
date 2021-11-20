package com.mph.service;

import java.util.List;

import com.mph.entity.Booking;

public interface BookingService
{

	public void createBooking(Booking booking);

	public List<Booking> deleteBooking(int bookingid);

	public List<Booking> getBookingList();

}
