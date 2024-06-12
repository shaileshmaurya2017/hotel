package com.hotel.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class RoomBookingDto {

	private Long BookingId;
	private Long guestId;
	
	private String name;
	private Long contactno;
	
	private Long roomId;
	private String RoomNo;
	
	private int status;
	private LocalDateTime localDate;
	private LocalDateTime updateDate;
	public Long getBookingId() {
		return BookingId;
	}
	public void setBookingId(Long bookingId) {
		BookingId = bookingId;
	}
	public Long getGuestId() {
		return guestId;
	}
	public void setGuestId(Long guestId) {
		this.guestId = guestId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getContactno() {
		return contactno;
	}
	public void setContactno(Long contactno) {
		this.contactno = contactno;
	}
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public String getRoomNo() {
		return RoomNo;
	}
	public void setRoomNo(String roomNo) {
		RoomNo = roomNo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public LocalDateTime getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDateTime localDate) {
		this.localDate = localDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public RoomBookingDto(Long bookingId, Long guestId, String name, Long contactno, Long roomId, String roomNo,
			int status, LocalDateTime localDate, LocalDateTime updateDate) {
		super();
		BookingId = bookingId;
		this.guestId = guestId;
		this.name = name;
		this.contactno = contactno;
		this.roomId = roomId;
		RoomNo = roomNo;
		this.status = status;
		this.localDate = localDate;
		this.updateDate = updateDate;
	}
	public RoomBookingDto() {
		super();
	}
	
	
}
