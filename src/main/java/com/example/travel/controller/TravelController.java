package com.example.travel.controller;

import com.example.travel.model.Response;
import com.example.travel.model.TravelDTO;
import com.example.travel.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "travel")
public class TravelController {

    @Autowired
    private TravelService travelService;

    @GetMapping("/")
    public ResponseEntity getTravelList(@RequestParam(name = "userId") long userId){
        Response response = Response.builder()
                .timeStamp(LocalDateTime.now())
                .status(OK)
                .reason("")
                .developerMessage("Returning travels")
                .data(Map.of("travels",travelService.getTravels(userId)))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("favorite")
    public ResponseEntity<Response> getFavorites(@RequestParam("userId") long userId){
        Response response = Response.builder()
                .timeStamp(LocalDateTime.now())
                .status(OK)
                .reason("")
                .developerMessage("Updating user avatar...")
                .data(Map.of("travels",travelService.getOnlyFavorites(userId)))
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("add")
    public void addTravel(@RequestBody TravelDTO travel){
        this.travelService.addTravel(travel);
    }

    @PostMapping("favorite")
    public void toggleFavorite(@RequestParam("userId") long userId,@RequestParam("travelId") long travelId){
        this.travelService.addToFavorite(userId,travelId);
    }
}
