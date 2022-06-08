package com.example.travel.services;

import com.example.travel.domain.ApplicationUser;
import com.example.travel.domain.MyUserDetailsService;
import com.example.travel.model.Comment;
import com.example.travel.model.Travel;
import com.example.travel.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private TravelService travelService;

    public List<Comment> getCommentsFromTravel(long id) {
        return this.commentRepository.findByTravel_Id(id);
    }

    public List<Comment> getCommentsFromUser(long id){
        return this.commentRepository.findByUser_Id(id);
    }

    public void addComment(Comment comment,long travelId){
        ApplicationUser user = myUserDetailsService.getUserById(comment.getUser().getId());
        Travel travel = travelService.getTravelById(travelId);
        comment.setTravel(travel);
        comment.setUser(user);
        this.commentRepository.save(comment);
    }
}
