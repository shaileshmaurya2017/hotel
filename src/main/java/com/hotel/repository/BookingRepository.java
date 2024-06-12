package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.model.RoomBooking;

public interface BookingRepository extends JpaRepository<RoomBooking, Integer> {

}
