package com.bilgeadam.MovieAppJava5.controller;

import com.bilgeadam.MovieAppJava5.repository.entity.MovieComment;
import com.bilgeadam.MovieAppJava5.service.MovieCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/moviecomment")
@RequiredArgsConstructor
public class MovieCommentController {

    private final MovieCommentService movieCommentService;

    @GetMapping("/comm")
    public List<MovieComment> searchMovieComments(long id){
        return movieCommentService.searchMovieComments(id);
    }

    @GetMapping("aralik")
    public ResponseEntity<List<MovieComment>> findByComments(String movie, String date1, String date2){
        return ResponseEntity.ok(movieCommentService.findByMovieCommentsAralik(movie,date1,date2));
    }

    @GetMapping("/moviecomments")
    public ResponseEntity<List<MovieComment>> movieComments(Long id){
        return ResponseEntity.ok(movieCommentService.movieComments(id));
    }

    @GetMapping("/klm")
    public ResponseEntity<List<MovieComment>>moviecomments(Long id, String date1, String date2){
        return ResponseEntity.ok(movieCommentService.findByMovieCommentsAralik2(id,date1,date2));
    }

    @GetMapping("/a")
    public ResponseEntity<List<MovieComment>> findByContentContainingIgnoreCase(String text){
        return ResponseEntity.ok(movieCommentService.findByContentContainingIgnoreCase(text));
    }
}
