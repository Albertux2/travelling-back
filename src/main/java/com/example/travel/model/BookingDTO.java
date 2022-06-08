package com.example.travel.model;

import com.example.travel.domain.ApplicationUser;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

public class BookingDTO {
    private long id;
    private TravelDTO travel;
    private Date startDate;
    private Date endDate;
    private boolean doubleBed;
    private int persons;
    private double price;

    public BookingDTO(Booking booking) {
        this.id = booking.getId();
        this.travel = new TravelDTO(booking.getTravel(),false);
        this.startDate = booking.getStartDate();
        this.endDate = booking.getEndDate();
        this.doubleBed = booking.isDoubleBed();
        this.persons = booking.getPersons();
        this.price = booking.getPrice();
    }

    public BookingDTO(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TravelDTO getTravel() {
        return travel;
    }

    public void setTravel(TravelDTO travel) {
        this.travel = travel;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isDoubleBed() {
        return doubleBed;
    }

    public void setDoubleBed(boolean doubleBed) {
        this.doubleBed = doubleBed;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
