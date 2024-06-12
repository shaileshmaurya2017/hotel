package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dto.RoomBookingDto;
import com.hotel.dto.RoomBookingMapper;
import com.hotel.dto.RoomDto;
import com.hotel.dto.RoomMapper;
import com.hotel.model.Room;
import com.hotel.model.RoomBooking;
import com.hotel.service.BookingService;
import com.hotel.service.RoomService;

@RestController
@RequestMapping("/api/booking/")
public class RoomBookingController {
	
	
	@Autowired
	BookingService bookingService;
	

	
	@Autowired
	RoomBookingMapper roombookingMapper;
	
	@GetMapping("/")
	public List<RoomBookingDto> getRoombookinglists() {
		
		List<RoomBooking> list = bookingService.getRoomBookings();
		//(Long bookingId, Long guestId, String name, Long contactno, Long roomId, String roomNo,
		//int status, LocalDateTime localDate, LocalDateTime updateDate
		List<RoomBookingDto> listdto = list.stream()
		.map((RoomBooking room)->new RoomBookingDto(room.getBookingId(),room.getGuestId(),room.getName(),room.getContactno(),room.getRoomId(),room.getRoomNo(),room.getStatus(),room.getLocalDate(),room.getUpdateDate())).toList();
		
		return listdto;
		
	}
	@PostMapping("/add")
	public ResponseEntity<RoomBookingDto> addRoom(@RequestBody RoomBooking roombooking) throws Exception {
		
		RoomBooking addedroombooking = bookingService.addBooking(roombooking);
		
		if(addedroombooking == null)
			throw new Exception("roombooking not saved");
		else {
			
			
			
		}
		
		return new ResponseEntity<RoomBookingDto>(roombookingMapper.mapRoomBookingtoRoomBookingDto(addedroombooking), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update{id}")
	public ResponseEntity<RoomBookingDto> updateRoomBooking(@RequestParam int id ,@RequestBody RoomBooking roombooking) throws Exception {
		
		RoomBooking ro = bookingService.getroombookingbyRoombookingid(id);
		if(ro == null)
			throw new Exception("no roombooking found ");
		RoomBooking addedroom = bookingService.addBooking(roombooking);
		
		if(addedroom == null)
			throw new Exception("roombooking not updated");
		
		return new ResponseEntity<RoomBookingDto>(roombookingMapper.mapRoomBookingtoRoomBookingDto(addedroom), HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/byid{id}")
	public RoomBookingDto getRoomBookingbyId(@RequestParam int id) throws Exception {
		
		RoomBooking room = bookingService.getroombookingbyRoombookingid(id);
		if(room == null)
			throw new Exception("room not found");
		
		
		return roombookingMapper.mapRoomBookingtoRoomBookingDto(room);
		
	}
	
	

}
