package com.hotel.dto;

import org.springframework.stereotype.Component;

import com.hotel.model.RoomBooking;

@Component
public class RoomBookingMapper {
	
	public RoomBookingDto mapRoomBookingtoRoomBookingDto (RoomBooking room)
	{
		RoomBookingDto rdto = new RoomBookingDto();
		rdto.setRoomId(room.getRoomId());
		rdto.setRoomNo(room.getRoomNo());
		rdto.setBookingId(room.getBookingId());
		rdto.setGuestId(room.getGuestId());
		rdto.setName(room.getName());
		rdto.setContactno(room.getContactno());
		rdto.setStatus(room.getStatus());
		rdto.setLocalDate(room.getLocalDate());
		rdto.setUpdateDate(room.getUpdateDate());
		
		return rdto;
	
	}

	public RoomBooking mapRoomBookingDtotoRoomBooking (RoomBookingDto roomdto)
	{
		RoomBooking room = new RoomBooking();
		room.setRoomId(roomdto.getRoomId());
		room.setRoomNo(roomdto.getRoomNo());
		room.setBookingId(roomdto.getBookingId());
		room.setGuestId(roomdto.getGuestId());
		room.setName(roomdto.getName());
		room.setContactno(roomdto.getContactno());
		room.setStatus(roomdto.getStatus());
		room.setLocalDate(roomdto.getLocalDate());
		room.setUpdateDate(roomdto.getUpdateDate());
		
		return room;
	
	}

}
