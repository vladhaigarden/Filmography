package com.epam.filmography.service;

import com.epam.filmography.model.Actor;

import java.util.List;

public interface ActorService {

    Actor save(Actor actor);

    List<Actor> getAllActors();

    Actor getActor(Long id);

    void delete(Actor actor);
}
