package com.bilgeadam.MovieAppJava5.service;

import com.bilgeadam.MovieAppJava5.repository.IMovieCommentRepository;
import com.bilgeadam.MovieAppJava5.repository.IMovieRepository;
import com.bilgeadam.MovieAppJava5.repository.entity.Movie;
import com.bilgeadam.MovieAppJava5.repository.entity.MovieComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieCommentService {

    private final IMovieCommentRepository movieCommentRepository;


    public List<MovieComment> searchMovieComments(long id){
        return movieCommentRepository.searchMovieComments(id);
    }

    public List<MovieComment> findByMovieCommentsAralik(String movie, String  date1, String  date2){
        return movieCommentRepository.findByMovieCommentsAralik(movie,LocalDate.parse(date1),LocalDate.parse(date2));
    }

    public List<MovieComment> findByMovieCommentsAralik2(Long id, String  date1,String  date2){
        return movieCommentRepository.findByMovieCommentsAralik2(id,LocalDate.parse(date1),LocalDate.parse(date2));
    }

    public List<MovieComment>movieComments(Long id){
        return movieCommentRepository.moviecomments(id);
    }

    public List<MovieComment> findByContentContainingIgnoreCase(String text){
        return movieCommentRepository.findByContentContainingIgnoreCase(text);
    }
}
