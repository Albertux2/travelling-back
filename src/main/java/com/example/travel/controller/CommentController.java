package com.example.travel.controller;

import com.example.travel.domain.MyUserDetailsService;
import com.example.travel.model.Comment;
import com.example.travel.model.Response;
import com.example.travel.services.CommentService;
import com.example.travel.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("comments")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @GetMapping("user")
    public ResponseEntity<Response> getCommentsFromUser(@RequestParam("userId") long userId){
        Response response = Response.builder()
                .timeStamp(LocalDateTime.now())
                .status(OK)
                .reason("")
                .developerMessage("Returning all comments")
                .data(Map.of("comments",commentService.getCommentsFromUser(userId)))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("travel")
    public ResponseEntity<Response> getCommentsFromTravel(@RequestParam("travelId") long travelId){
        Response response = Response.builder()
                .timeStamp(LocalDateTime.now())
                .status(OK)
                .reason("")
                .developerMessage("Returning all comments")
                .data(Map.of("comments",commentService.getCommentsFromTravel(travelId)))
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/post")
    public boolean addComment(@RequestBody Comment comment,@RequestParam(name = "travelId") long travelId){
        this.commentService.addComment(comment,travelId);
        return true;
    }
}
