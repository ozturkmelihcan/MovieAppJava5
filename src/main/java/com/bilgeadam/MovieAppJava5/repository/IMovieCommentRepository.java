package com.bilgeadam.MovieAppJava5.repository;

import com.bilgeadam.MovieAppJava5.repository.entity.Movie;
import com.bilgeadam.MovieAppJava5.repository.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface IMovieCommentRepository extends JpaRepository<MovieComment,Long> {

  //  List<MovieComment> findAllByMoviesInOrderByComments(List<Movie>movies);

    @Query("select m from MovieComment  as m where m.movie.id=?1")
    List<MovieComment> searchMovieComments(long id);

    @Query(value = "select * from movie_comment inner join movie on movie_comment.movie_id = movie.id where movie.name=?1 and  movie_comment.date between ?2 and ?3",nativeQuery = true)
   List<MovieComment> findByMovieCommentsAralik(String movie, LocalDate date1,LocalDate date2);


    @Query(value = "select * from movie_comment inner join tbl_user on movie_comment.user_id = tbl_user.id where tbl_user.id=?1 and  movie_comment.date between ?2 and ?3",nativeQuery = true)
   List<MovieComment> findByMovieCommentsAralik2(Long id, LocalDate date1,LocalDate date2);

    @Query(value = "select * from movie_comment inner join tbl_user on movie_comment.user_id = tbl_user.id where tbl_user.id = ?1",nativeQuery = true)
    List<MovieComment>moviecomments(Long id);

    List<MovieComment> findByContentContainingIgnoreCase(String text);

}
