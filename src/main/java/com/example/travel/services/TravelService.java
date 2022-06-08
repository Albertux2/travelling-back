package com.example.travel.services;

import com.example.travel.domain.ApplicationUser;
import com.example.travel.domain.UserRepository;
import com.example.travel.model.Favorite;
import com.example.travel.repositories.FavoriteRepository;
import com.example.travel.model.Travel;
import com.example.travel.model.TravelDTO;
import com.example.travel.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TravelService {
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private TravelRepository travelRepository;
    @Autowired
    private UserRepository userRepo;

    public List<TravelDTO> getTravels(long userId) {
        List<TravelDTO> travelDTOs = new ArrayList<TravelDTO>();
        List<Travel> travels = (List<Travel>) this.travelRepository.findAll();
        List<Favorite> favorites = favoriteRepository.findByUser_Id(userId);
        for (Travel travel : travels) {
            int index = 0;
            boolean favorite = false;
            while (index < favorites.size() && !favorite) {
                if (travel.getId() == favorites.get(index).getTravelId()) {
                    favorite = true;
                }
                index++;
            }
            travelDTOs.add(new TravelDTO(travel, favorite));
        }
        return travelDTOs;
    }

    public List<TravelDTO> getOnlyFavorites(long userId) {
        return this.getTravels(userId).stream().filter((e) -> e.isFavorite()).collect(Collectors.toList());
    }

    public Travel getTravelById(long id) {
        Optional<Travel> travel = travelRepository.findById(id);
        return travel.orElse(null);
    }

    public void addToFavorite(long userId, long travelId) {
        Optional<Favorite> optional = favoriteRepository.findByUser_IdAndTravel_Id(userId,travelId);
        optional.ifPresentOrElse(
                favorite -> this.favoriteRepository.delete(favorite),
                ()->{
                    ApplicationUser user = userRepo.findById(userId).get();
                    Travel travel = travelRepository.findById(travelId).get();
                    Favorite favorite = new Favorite(user, travel);
                    favoriteRepository.save(favorite);
                }
        );
    }

    public void addTravel(TravelDTO travelDTO) {
        Travel travel = new Travel(travelDTO);
        this.travelRepository.save(travel);
    }
}
