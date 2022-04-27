/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oracle.reservationservice.controller;

import com.oracle.reservationservice.entity.Booking;
import com.oracle.reservationservice.entity.Flight;
import com.oracle.reservationservice.entity.User;
import com.oracle.reservationservice.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 *
 * @author sanch
 */

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;
    
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getAllBookings")
    public List<Booking> getAllBookings(){
        return reservationService.getAllBookings();
    }


    @GetMapping("/book/{flightId}/{userId}") //
    public String getBookings(@PathVariable Integer flightId, @PathVariable Integer userId){
        Flight flight = restTemplate.getForObject("http://localhost:8081/flights/" + flightId , Flight.class);
        Integer flightPrice = flight.getPrice();
        boolean seatCheck = restTemplate.getForObject("http://localhost:8081/flights/checkIfSeatsAvailable/" + flightId, Boolean.class);
        if(seatCheck) {
            User user = restTemplate.getForObject("http://localhost:8080/user/find/" + userId, User.class);
            Integer customerAge = user.getAge();
            String date = reservationService.getCurrentTimeUsingDate();
            Booking booking;
            if(customerAge > 4) {
                booking  = new Booking(date, userId, user.getName(), flightId, flight.getSource(), flight.getDest(), flightPrice);
                reservationService.saveFlightDetails(booking);

                return "booking done and your flight id is " + flight.getFlightId() + " And you booking id is " + booking.getBookingId();
            } else {
                booking  = new Booking(date, userId, user.getName(), flightId, flight.getSource(), flight.getDest(), flightPrice/2);
                reservationService.saveFlightDetails(booking);
                return "Ae half ticket -> Booking done and your flight id is " + flight.getFlightId() + " And you booking id is " + booking.getBookingId();
            }

        }
        return "No seats Available. No booking done.";
    }
    @RequestMapping("/{flightId}")
    public List<Booking> getFlightsById(@PathVariable("flightId") Integer flightId) {
        List<Booking> bookings = reservationService.getBookingByFlightId(flightId);
        return bookings;
    }

    @RequestMapping("/bookingId/{bookingId}")
    public List<Booking> getBookingByBookingId(@PathVariable("bookingId") Integer bookingId) {
        List<Booking> bookings = reservationService.getBookingByBookingId(bookingId);
        return bookings;
    }

    
    @PostMapping("/")
    public Booking addFlightBookingData(@RequestBody Booking booking) {
        return reservationService.saveFlightDetails(booking);
    }
    
    
    @DeleteMapping("{bookingId}")
    public void cancelFlightById(@PathVariable Integer bookingId) {
           reservationService.deleteReservationById(bookingId);
    }
    

}

// Return list of userIds to flight microservice according to flightIds requested.