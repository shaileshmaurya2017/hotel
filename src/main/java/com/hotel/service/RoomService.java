package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Room;
import com.hotel.repository.RoomRepository;

@Service
public class RoomService {
	@Autowired
	private RoomRepository repo;
	
	public List<Room> getRooms()
	{
		
		return repo.findAll();
			
	}
	
	public Room  addRoom(Room room)
	{
		return repo.save(room);
	}
	
	public Room  getroombyRoomid(int id)
	{
		return repo.findById(id).get();
	
	}

}
