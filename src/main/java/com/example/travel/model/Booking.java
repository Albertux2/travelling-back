package com.example.travel.model;

import com.example.travel.domain.ApplicationUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "ID_User")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ApplicationUser user;
    @OneToOne
    @JoinColumn(name = "ID_Travel")
    private Travel travel;
    private Date startDate;
    private Date endDate;
    private boolean doubleBed;
    private int persons;
    private double price;

    public Booking(){
    }

    public Booking(ApplicationUser user, Travel travel, Date startDate, Date endDate, boolean doubleBed, int persons, double price) {
        this.user = user;
        this.travel = travel;
        this.startDate = startDate;
        this.endDate = endDate;
        this.doubleBed = doubleBed;
        this.persons = persons;
        this.price = price;
    }

    public long getId() {
        return id;
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

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
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

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }
}
