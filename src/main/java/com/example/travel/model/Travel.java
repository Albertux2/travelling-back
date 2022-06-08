package com.example.travel.model;

import javax.persistence.*;

@Entity
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imgUrl;
    private String content;
    private String hotelName;
    private String travelType;
    private int valoration;
    private double price;
    private String location;

    public Travel(){}

    public Travel(String imgUrl, String content, String hotelName, String travelType, int valoration, double price, String location) {
        this.imgUrl = imgUrl;
        this.content = content;
        this.hotelName = hotelName;
        this.travelType = travelType;
        this.valoration = valoration;
        this.price = price;
        this.location = location;
    }

    public Travel(String content, String hotelName, String travelType, int valoration, double price, String location) {
        this.content = content;
        this.hotelName = hotelName;
        this.travelType = travelType;
        this.valoration = valoration;
        this.price = price;
        this.location = location;
    }

    public Travel(TravelDTO dto){
        this.content = dto.getContent();
        this.hotelName = dto.getTitle();
        this.travelType = dto.getType();
        this.valoration = dto.getValoration();
        this.price = dto.getPrice();
        this.location = dto.getLocation();
        this.imgUrl = dto.getImgUrl();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public int getValoration() {
        return valoration;
    }

    public void setValoration(int valoration) {
        this.valoration = valoration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }
}
