package com.epam.filmography.service;

import com.epam.filmography.model.Movie;

import java.util.List;

public interface MovieService {

    Movie save(Movie movie);

    List<Movie> getAllAMovies();

    Movie getMovie(Long id);

    void delete(Movie movie);
}