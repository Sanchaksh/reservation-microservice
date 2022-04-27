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
@Table(name = "reservation")
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;
    
    @Column(name = "bookDate")
    private String bookDate;
    
    @Column(name = "userId")
    private Integer userId;

    @Column(name = "userName")
    private String userName;
    
    @Column(name = "flightId")
    private Integer flightId;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private String destination;

    @Column(name = "price")
    private Integer price;

    /*---------------------Constructors--------------------*/

    public Booking() {
    }



    public Booking(String book_date, Integer user_id, String user_name, Integer flight_id, String source, String destination, Integer price) {
        this.bookDate = book_date;
        this.userId = user_id;
        this.userName = user_name;
        this.flightId = flight_id;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    /*------------------Getters & Setters------------------*/

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public String getBook_Date() {
        return bookDate;
    }

    public void setBook_Date(String bookDate) {
        this.bookDate = bookDate;
    }

    public Integer getuserId() {
        return userId;
    }

    public void setuserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getflightId() {
        return flightId;
    }

    public void setflightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}// Booking Class
