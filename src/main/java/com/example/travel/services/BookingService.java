package com.example.travel.services;

import com.example.travel.domain.UserRepository;
import com.example.travel.model.Booking;
import com.example.travel.model.BookingDTO;
import com.example.travel.repositories.BookingRepository;
import com.example.travel.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TravelRepository travelRepository;

    public List<BookingDTO> getBookingListByUserId(long id){
        List<Booking> history = this.bookingRepository.findByUser_Id(id);
        Date today = new Date(new Date().getTime());
        List<Booking> bookings = history.stream().filter((b)->{
            return today.before(b.getEndDate());
        }).collect(Collectors.toList());
        List<BookingDTO> dtos = new ArrayList<BookingDTO>();
        for (Booking booking:bookings) {
            dtos.add(new BookingDTO(booking));
        }
        return dtos;
    }

    public void makeBooking(Booking booking){
        this.bookingRepository.save(booking);
    }

    public List<BookingDTO> getHistoryListByUserId(long id) {
        List<Booking> bookings = this.bookingRepository.findByUser_Id(id);
        List<BookingDTO> dtos = new ArrayList<BookingDTO>();
        for (Booking booking:bookings) {
            dtos.add(new BookingDTO(booking));
        }
        return dtos;
    }
}
