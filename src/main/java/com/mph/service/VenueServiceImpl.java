package com.mph.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.VenueDao;
import com.mph.entity.Venue;

@Service
@Transactional
public class VenueServiceImpl implements VenueService
{   
	@Autowired
	VenueDao venueDao;
	
	public List<Venue> deleteVenue(int venueid)
	{
		return venueDao.deleteVenue(venueid);
	}
	
	public List<Venue> updateVenue(Venue venue)
	{
		return venueDao.updateVenue(venue);
	}

	public void createVenue(Venue venue)
	{
		venueDao.createVenue(venue);
	}

	public List<Venue> getVenueList()
	{
		return venueDao.getVenueList();
	}


}
