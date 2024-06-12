package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Guest;
import com.hotel.repository.GuestRepository;

@Service
public class GuestService {
	
	@Autowired
	GuestRepository guestrepository;
	
	public List<Guest> getGuestlist(){
		
		return guestrepository.findAll();
	}
	
	public Guest  addGuest(Guest guest)
	{
		return guestrepository.save(guest);
	}
	
	public Guest  getguestbyGuestid(int id)
	{
		return guestrepository.findById(id).get();
	
	}

}
