package com.mph.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.BookingDao;
import com.mph.dao.CustomerDao;
import com.mph.entity.Booking;
import com.mph.entity.Customer;

@Service
@Transactional
public class BookingServiceImpl implements BookingService
{
	
	@Autowired
	BookingDao bookingDao;

	@Override
	public List<Booking> getBookingList() {
		
		return bookingDao.getBookingList();
	}


	@Override
	public void createBooking(Booking booking) {
		bookingDao.createBooking(booking);
	}

	@Override
	public List<Booking> deleteBooking(int bookingid) {
		
		return bookingDao.deleteBooking(bookingid);
	}
}