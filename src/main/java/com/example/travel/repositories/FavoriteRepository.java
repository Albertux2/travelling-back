package com.example.travel.repositories;

import com.example.travel.model.Favorite;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends CrudRepository<Favorite, Long> {
    public List<Favorite> findByUser_Id(Long userId);

    public Optional<Favorite> findByUser_IdAndTravel_Id(long userId, long travelId);
}