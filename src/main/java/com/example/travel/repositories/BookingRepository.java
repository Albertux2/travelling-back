package com.example.travel.repositories;

import com.example.travel.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

    public List<Booking> findByUser_Username(String username);

    List<Booking> findByUser_Id(long id);
}