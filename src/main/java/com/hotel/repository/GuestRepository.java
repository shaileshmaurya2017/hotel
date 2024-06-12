package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Integer> {

}
