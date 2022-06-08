package com.example.travel.repositories;

import com.example.travel.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    public List<Comment> findByUser_Id(long userId);
    public List<Comment> findByTravel_Id(long travelId);
}