package com.hotel.dto;

import org.springframework.stereotype.Component;

import com.hotel.model.Guest;

@Component
public class GuestMapper {
	public GuestDto mapGuesttoGuestDto (Guest guest)
	{
		GuestDto gdto = new GuestDto();
		gdto.setGuestId(guest.getGuestId());
		gdto.setContactno(guest.getContactno());
		gdto.setLocalDate(guest.getLocalDate());
		gdto.setName(guest.getName());
		gdto.setStatus(guest.getStatus());
		gdto.setUpdateDate(guest.getUpdateDate());
		gdto.setValiddocno(guest.getValiddocno());
		
		return gdto;
	
	}

	public Guest mapGuestDtotoGuest (GuestDto guestdto)
	{
		Guest g = new Guest();
		g.setGuestId(guestdto.getGuestId());
		g.setContactno(guestdto.getContactno());
		g.setLocalDate(guestdto.getLocalDate());
		g.setName(guestdto.getName());
		g.setStatus(guestdto.getStatus());
		g.setUpdateDate(guestdto.getUpdateDate());
		g.setValiddocno(guestdto.getValiddocno());
		return g;
		
	}

}
