package com.example.travel.model;

import com.example.travel.domain.ApplicationUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Favorite {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private ApplicationUser user;
    @OneToOne
    @JoinColumn(name = "travelId")
    @JsonIgnore
    private Travel travel;

    public Favorite(){}

    public Favorite(ApplicationUser user, Travel travel){
        this.user = user;
        this.travel = travel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId(){
        return user.getId();
    }

    public long getTravelId(){
        return travel.getId();
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
}
