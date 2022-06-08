package com.example.travel.model;

public class TravelDTO {
    private Long id;
    private String imgUrl;
    private String content;
    private String title;
    private String type;
    private String location;
    private int valoration;
    private double price;
    private boolean favorite;

    public TravelDTO(){}

    public TravelDTO(Travel travel, boolean favorite){
        this.id = travel.getId();
        this.imgUrl = travel.getImgUrl();
        this.content = travel.getContent();
        this.title = travel.getHotelName();
        this.type = travel.getTravelType();
        this.valoration = travel.getValoration();
        this.price = travel.getPrice();
        this.favorite = favorite;
        this.location = travel.getLocation();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
