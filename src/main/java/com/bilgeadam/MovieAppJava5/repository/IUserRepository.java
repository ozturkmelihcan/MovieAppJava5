package com.bilgeadam.MovieAppJava5.repository;

import com.bilgeadam.MovieAppJava5.repository.entity.Movie;
import com.bilgeadam.MovieAppJava5.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {


    List<User> findAllByOrderByName();

    List<User> findAllByNameLike(String name);

    List<User> findByEmailContainingIgnoreCase(String value);

    List<User> findByEmailEndingWith(String value);

    Optional<User> findOptionalByEmailAndPassword(String email, String password);

    Boolean existsByEmailAndPassword(String email,String password);

    @Query(value = "select * from tbl_user where length(password)>?1 ",nativeQuery = true)
    List<User>passwordLongerThan(int length);

    @Query(value = "select u from User as u where length(u.password)>?1")
    List<User> passwordControl(int length);

    @Query(value = "select u from User as u where length(u.password)>:x")
    List<User>passwordControl2(@Param("x")int length);
}
