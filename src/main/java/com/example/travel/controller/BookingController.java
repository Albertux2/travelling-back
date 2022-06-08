package com.example.travel.controller;

import com.example.travel.model.Booking;
import com.example.travel.model.Response;
import com.example.travel.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("booking")
    public ResponseEntity<Response> getBookingsByUser(@RequestParam(value = "userId") long id) {
        Response response = Response.builder()
                .timeStamp(LocalDateTime.now())
                .status(OK)
                .reason("")
                .developerMessage("Returning bookings")
                .data(Map.of("bookings",bookingService.getBookingListByUserId(id)))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("history")
    public ResponseEntity<Response> getBookingHistoryByUser(@RequestParam(value="userId") long id){
        Response response = Response.builder()
                .timeStamp(LocalDateTime.now())
                .status(OK)
                .reason("")
                .developerMessage("Returning bookings")
                .data(Map.of("bookings", bookingService.getHistoryListByUserId(id)))
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("booking")
    public void makeBooking(@RequestBody Booking booking){
        this.bookingService.makeBooking(booking);
    }

}

