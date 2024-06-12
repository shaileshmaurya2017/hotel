package com.hotel.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class GuestDto {

	private Long guestId;
	private String validdocno;
	private String name;
	private Long contactno;
	private int status;
	private LocalDateTime localDate;
	private LocalDateTime updateDate;
	public Long getGuestId() {
		return guestId;
	}
	public void setGuestId(Long guestId) {
		this.guestId = guestId;
	}
	public String getValiddocno() {
		return validdocno;
	}
	public void setValiddocno(String validdocno) {
		this.validdocno = validdocno;
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
	public GuestDto(Long guestId, String validdocno, String name, Long contactno, int status, LocalDateTime localDate,
			LocalDateTime updateDate) {
		super();
		this.guestId = guestId;
		this.validdocno = validdocno;
		this.name = name;
		this.contactno = contactno;
		this.status = status;
		this.localDate = localDate;
		this.updateDate = updateDate;
	}
	public GuestDto() {
		super();
	}
	
	
}
