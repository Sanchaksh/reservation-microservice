/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oracle.reservationservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sanch
 */

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;

    @Column(nullable = false)
    private String flightName;

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private String dest;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer availableSeats;

//    @Column(name = "departure_date")
// @JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
//    private String deptDateTime;

//    @Column(name = "arrival_date")
// @JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
//    private String arrDateTime;


    public Flight() {
    }


    public Flight(Integer flightId, String flightName, String source, String dest, Integer price, Integer capacity, Integer availableSeats) {
        super();
        this.flightId = flightId;
        this.flightName = flightName;
        this.source = source;
        this.dest = dest;
        this.price = price;
        this.availableSeats=availableSeats;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getSource() {
        return source;
    }

    public String getDest() {
        return dest;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", flightName='" + flightName + '\'' +
                ", source='" + source + '\'' +
                ", dest='" + dest + '\'' +
                ", price=" + price +
                '}';
    }
}