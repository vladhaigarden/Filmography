package com.epam.filmography.controller;

import com.epam.filmography.model.Movie;
import com.epam.filmography.model.Views;
import com.epam.filmography.service.MovieService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public Movie save(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @GetMapping
    @JsonView(Views.Actors.class)
    public List<Movie> findAllMovies() {
        return movieService.getAllAMovies();
    }

    @GetMapping("{id}")
    @JsonView(Views.Actors.class)
    public Movie findMovie(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @PutMapping("{id}")
    @JsonView(Views.Actors.class)
    public Movie update(@RequestBody Movie movie, @PathVariable Long id) {
        movie.setId(id);
        return movieService.save(movie);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Movie movie) {
        movieService.delete(movie);
    }
}