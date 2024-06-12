package com.hotel.controller;

import java.io.IOException;
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

import com.hotel.dto.RoomDto;
import com.hotel.dto.RoomMapper;
import com.hotel.model.Room;
import com.hotel.service.InvoiceService;
import com.hotel.service.RoomService;
import com.itextpdf.text.DocumentException;

@RestController
@RequestMapping("/api/room")
public class RoomController {
	@Autowired
	RoomService roomService;
	
	@Autowired
	RoomMapper roomMapper;
	@Autowired
	InvoiceService invoiceservice;
	
	@GetMapping("/")
	public List<RoomDto> getRooms() throws IOException, DocumentException {
		
		List<Room> list = roomService.getRooms();
		
		List<RoomDto> listdto = list.stream()
		.map((Room room)->new RoomDto(room.getRoomId(),room.getRoomNo(),room.getRoomRate(),room.getStatus(),room.getLocalDate(),room.getUpdateDate()))
		.toList();
		invoiceservice.addchunk(1133L);
		invoiceservice.generateInvoice2(12234L);
		invoiceservice.generateInvoice3(432355L);
		return listdto;
		
	}
	@PostMapping("/add")
	public ResponseEntity<RoomDto> addRoom(@RequestBody Room room) throws Exception {
		
		Room addedroom = roomService.addRoom(room);
		
		if(addedroom == null)
			throw new Exception("room not saved");
		
		return new ResponseEntity<RoomDto>(roomMapper.mapRoomtoRoomDto(addedroom), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update{id}")
	public ResponseEntity<RoomDto> updateRoom(@RequestParam int id ,@RequestBody Room room) throws Exception {
		
		Room ro = roomService.getroombyRoomid(id);
		if(ro == null)
			throw new Exception("no room found ");
		Room addedroom = roomService.addRoom(room);
		
		if(addedroom == null)
			throw new Exception("room not updated");
		
		return new ResponseEntity<RoomDto>(roomMapper.mapRoomtoRoomDto(addedroom), HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/byid{id}")
	public RoomDto getRoombyId(@RequestParam int id) throws Exception {
		
		Room room = roomService.getroombyRoomid(id);
		if(room == null)
			throw new Exception("room not found");
		
		
		return roomMapper.mapRoomtoRoomDto(room);
		
	}
	

}
