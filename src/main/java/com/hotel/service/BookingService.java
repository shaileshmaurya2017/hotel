package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.model.Room;
import com.hotel.model.RoomBooking;
import com.hotel.repository.BookingRepository;



@Service
public class BookingService {

	@Autowired
	private BookingRepository repo;
	
	private RoomService roomservice;
	
	public List<RoomBooking> getRoomBookings()
	{
		
		return repo.findAll();
			
	}
	
	@Transactional(isolation=Isolation.SERIALIZABLE)
	public RoomBooking  addBooking(RoomBooking roomBooking)
	{
		
		long bookingid = roomBooking.getBookingId();
		
		RoomBooking bookingobj = getroombookingbyRoombookingid((int)bookingid);
		
		if(bookingobj != null)
		{
			long oldroomid = bookingobj.getRoomId();
			Room rm1 = roomservice.getroombyRoomid((int)oldroomid);
			rm1.setStatus(3);
			roomservice.addRoom(rm1);
		}
		
		long roomid = roomBooking.getRoomId();
		RoomBooking rb = repo.save(roomBooking);
		
		Room rm = roomservice.getroombyRoomid((int)roomid);
		rm.setStatus(2);
		roomservice.addRoom(rm);
		return rb;
	}
	
	public RoomBooking  getroombookingbyRoombookingid(int id)
	{
		return repo.findById(id).get();
	
	}
}
