package com.example.travel.model;

import com.example.travel.domain.ApplicationUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "ID_USER")
    private ApplicationUser user;
    @OneToOne
    @JoinColumn(name = "ID_TRAVEL")
    private Travel travel;
    private String message;
    private int rating;
    private Date date;

    public Comment(){}

    public Comment(ApplicationUser user, Travel travel, String message, int rating) {
        this.user = user;
        this.travel = travel;
        this.message = message;
        this.rating = rating;
        this.date = new Date();
    }

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

}
