/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oracle.reservationservice.repository;

import com.oracle.reservationservice.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author sanch
 */
public interface ReservationRepository extends JpaRepository<Booking, Integer>{

    List<Booking> findAllByFlightId(Integer flightId);

    List<Booking> findAllByBookingId(Integer bookingId);
}
