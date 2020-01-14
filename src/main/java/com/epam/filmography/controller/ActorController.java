package com.epam.filmography.controller;

import com.epam.filmography.model.Actor;
import com.epam.filmography.model.Views;
import com.epam.filmography.service.ActorService;
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
@RequestMapping("actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping
    public Actor save(@RequestBody Actor actor) {
        actorService.save(actor);
        return actor;
    }

    @GetMapping
    @JsonView(Views.Movies.class)
    public List<Actor> findAllActors() {
        return actorService.getAllActors();
    }

    @GetMapping("{id}")
    @JsonView(Views.Movies.class)
    public Actor findActor(@PathVariable Long id) {
        return actorService.getActor(id);
    }

    @PutMapping("{id}")
    @JsonView(Views.Movies.class)
    public Actor update(@RequestBody Actor actor, @PathVariable Long id) {
        actor.setId(id);
        return actorService.save(actor);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Actor actor) {
        actorService.delete(actor);
    }
}