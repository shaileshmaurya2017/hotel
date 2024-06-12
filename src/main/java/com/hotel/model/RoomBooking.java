package com.hotel.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class RoomBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long BookingId;
	private Long guestId;
	private Long guestId1;
	private Long guestId2;
	private Long guestId3;
	private Long guestId4;
	private String name;
	private Long contactno;
	
	private Long roomId;
	private String RoomNo;
	
	private int status;
	@CreationTimestamp
	private LocalDateTime localDate;
	@UpdateTimestamp
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
	public RoomBooking(Long bookingId, Long guestId, String name, Long contactno, Long roomId, String roomNo,
			int status, LocalDateTime localDate, LocalDateTime updateDate) {
		super();
		BookingId = bookingId;
		this.guestId = guestId;
		this.name = name;
		this.contactno = contactno;
		this.roomId = roomId;
		this.RoomNo = roomNo;
		this.status = status;
		this.localDate = localDate;
		this.updateDate = updateDate;
	}
	public RoomBooking() {
		super();
	}
	public Long getGuestId1() {
		return guestId1;
	}
	public void setGuestId1(Long guestId1) {
		this.guestId1 = guestId1;
	}
	public Long getGuestId2() {
		return guestId2;
	}
	public void setGuestId2(Long guestId2) {
		this.guestId2 = guestId2;
	}
	public Long getGuestId3() {
		return guestId3;
	}
	public void setGuestId3(Long guestId3) {
		this.guestId3 = guestId3;
	}
	public Long getGuestId4() {
		return guestId4;
	}
	public void setGuestId4(Long guestId4) {
		this.guestId4 = guestId4;
	}
	public RoomBooking(Long bookingId, Long guestId, Long guestId1, Long guestId2, Long guestId3, Long guestId4,
			String name, Long contactno, Long roomId, String roomNo, int status, LocalDateTime localDate,
			LocalDateTime updateDate) {
		super();
		BookingId = bookingId;
		this.guestId = guestId;
		this.guestId1 = guestId1;
		this.guestId2 = guestId2;
		this.guestId3 = guestId3;
		this.guestId4 = guestId4;
		this.name = name;
		this.contactno = contactno;
		this.roomId = roomId;
		RoomNo = roomNo;
		this.status = status;
		this.localDate = localDate;
		this.updateDate = updateDate;
	}
	
	

}
