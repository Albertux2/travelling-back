package com.example.travel.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<ApplicationUser,Long> {
    public Optional<ApplicationUser> findByUsername(String username);

}
