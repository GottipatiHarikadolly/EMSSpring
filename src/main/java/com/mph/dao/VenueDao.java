package com.mph.dao;

import java.util.List;

import com.mph.entity.Venue;

public interface VenueDao {

	public List<Venue> deleteVenue(int venueid);

	public List<Venue> updateVenue(Venue venue);

	public void createVenue(Venue venue);

	public List<Venue> getVenueList();

}
