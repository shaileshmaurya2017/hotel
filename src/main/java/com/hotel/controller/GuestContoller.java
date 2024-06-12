package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dto.GuestDto;
import com.hotel.dto.GuestMapper;
import com.hotel.model.Guest;
import com.hotel.service.GuestService;

@RestController
@RequestMapping("/api/guest")
public class GuestContoller {
	
	@Autowired
	GuestService guestService;
	
	@Autowired
	GuestMapper guestMapper;
	
	@GetMapping("/")
	public List<GuestDto> getGuests() {
		
		List<Guest> list = guestService.getGuestlist();
		
		List<GuestDto> listdto = list.stream()
		.map((Guest guest)->new GuestDto(guest.getGuestId(),guest.getValiddocno(),guest.getName(),guest.getContactno(),guest.getStatus(),guest.getLocalDate(),guest.getUpdateDate()))
		.toList();
		
		return listdto;
		
	}
	@PostMapping("/add")
	public ResponseEntity<GuestDto> addGuest(@RequestBody Guest guest) throws Exception {
		
		Guest addedguest = guestService.addGuest(guest);
		
		if(addedguest == null)
			throw new Exception("guest not saved");
		
		return new ResponseEntity<GuestDto>(guestMapper.mapGuesttoGuestDto(addedguest), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update{id}")
	public ResponseEntity<GuestDto> updateGuest(@RequestParam int id ,@RequestBody Guest guest) throws Exception {
		
		Guest gu = guestService.getguestbyGuestid(id);
		if(gu == null)
			throw new Exception("no guest found ");
		Guest addedguest = guestService.addGuest(guest);
		
		if(addedguest == null)
			throw new Exception("guest not updated");
		
		return new ResponseEntity<GuestDto>(guestMapper.mapGuesttoGuestDto(addedguest), HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/byid{id}")
	public GuestDto getRoombyId(@RequestParam int id) throws Exception {
		
		Guest guest = guestService.getguestbyGuestid(id);
		if(guest == null)
			throw new Exception("guest not found");
		
		
		return guestMapper.mapGuesttoGuestDto(guest);
		
	}
	

}
