package com.epam.filmography.service.impl;

import com.epam.filmography.exception.NotFoundException;
import com.epam.filmography.model.Movie;
import com.epam.filmography.repository.MovieRepository;
import com.epam.filmography.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllAMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovie(Long id) {
        return movieRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }
}