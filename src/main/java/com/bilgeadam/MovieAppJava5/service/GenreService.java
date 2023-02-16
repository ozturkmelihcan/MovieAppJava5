package com.bilgeadam.MovieAppJava5.service;

import com.bilgeadam.MovieAppJava5.repository.IGenreRepository;

import com.bilgeadam.MovieAppJava5.repository.entity.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
/*
String name d�sardan al�nan veri (Drama) bu veriye uygun bir metot findbyname genre name ine
g�re bir genre getiren metotu repositoryde olustural�m

 */
public class GenreService {

    private final IGenreRepository genreRepository;

    public List<Genre> createGenresWithNames(List<String> genres) {
        List<Genre> genresList=new ArrayList<>();

        for (String name:genres){
            Optional<Genre> genre=genreRepository.findOptionalByName(name);
            if(genre.isPresent()){
                genresList.add(genre.get()); //databasedeki nesneyi ekleyecegiz
            }else{
                Genre genre1= Genre.builder().name(name).build();
                genreRepository.save(genre1);
             //   genresList.add(genreRepository.save(Genre.builder().name(name).build()));
                genresList.add(genre1); //yeni bir genre ollustrup onu ekleyecegiz
            }
        }


        return  genresList;
    }


}
