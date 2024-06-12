package com.hotel.dto;

import org.springframework.stereotype.Component;

import com.hotel.model.Room;

@Component
public class RoomMapper {
	
	public RoomDto mapRoomtoRoomDto (Room room)
	{
		RoomDto rdto = new RoomDto();
		rdto.setRoomId(room.getRoomId());
		rdto.setRoomNo(room.getRoomNo());
		rdto.setRoomRate(room.getRoomRate());
		rdto.setStatus(room.getStatus());
		rdto.setLocalDate(room.getLocalDate());
		rdto.setUpdateDate(room.getUpdateDate());
		
		return rdto;
	
	}

	public Room mapRoomDtotoRoom (RoomDto roomdto)
	{
		Room room = new Room();
		room.setRoomId(roomdto.getRoomId());
		room.setRoomNo(roomdto.getRoomNo());
		room.setRoomRate(roomdto.getRoomRate());
		room.setStatus(roomdto.getStatus());
		room.setLocalDate(roomdto.getLocalDate());
		room.setUpdateDate(roomdto.getUpdateDate());
		
		return room;
	
	}
}
