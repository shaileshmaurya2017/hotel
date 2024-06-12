package com.hotel.dto;


import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {

	private Long roomId;
	private String RoomNo;
	private String RoomRate;
	private int Status;
	private LocalDateTime localDate;
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
	public RoomDto(Long roomId, String roomNo, String roomRate, int status, LocalDateTime localDate, LocalDateTime updateDate) {
		super();
		this.roomId = roomId;
		RoomNo = roomNo;
		RoomRate = roomRate;
		Status = status;
		this.localDate = localDate;
		this.updateDate = updateDate;
	}
	public RoomDto() {
		super();
	}


}
