package com.hotel.model;

import java.time.LocalDate;
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

public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long roomId;
	private String RoomNo;
	private String RoomRate;
	private int Status;
	@CreationTimestamp
	private LocalDateTime localDate;
	@UpdateTimestamp
	private LocalDateTime updateDate;
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
	public String getRoomRate() {
		return RoomRate;
	}
	public void setRoomRate(String roomRate) {
		RoomRate = roomRate;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
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
	public Room(Long roomId, String roomNo, String roomRate, int status, LocalDateTime localDate,
			LocalDateTime updateDate) {
		super();
		this.roomId = roomId;
		RoomNo = roomNo;
		RoomRate = roomRate;
		Status = status;
		this.localDate = localDate;
		this.updateDate = updateDate;
	}
	public Room() {
		super();
	}

}
