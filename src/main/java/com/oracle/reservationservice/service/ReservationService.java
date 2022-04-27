/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oracle.reservationservice.service;

import com.oracle.reservationservice.entity.Booking;
import com.oracle.reservationservice.repository.ReservationRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sanch
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
	public Booking saveFlightDetails(Booking flight) {
		return reservationRepository.save(flight);
	}

    public List<Booking> getBookingByFlightId(Integer flightId) {
         return reservationRepository.findAllByFlightId(flightId);
    }

    public List<Booking> getBookingByBookingId(Integer bookingId) {
        return reservationRepository.findAllByBookingId(bookingId);
    }

	public Booking updateReservation(Booking flight) {
		return reservationRepository.save(flight);
	}

	public void deleteReservationById(Integer id) {
		reservationRepository.deleteById(id);	
	}
        
        public static String getCurrentTimeUsingDate() {
          Date date = new Date();
          String strDateFormat = "hh:mm:ss a";
          DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
          String formattedDate= dateFormat.format(date);
          return formattedDate;
}

    public List<Booking> getAllBookings() {
        return reservationRepository.findAll();
    }
}
