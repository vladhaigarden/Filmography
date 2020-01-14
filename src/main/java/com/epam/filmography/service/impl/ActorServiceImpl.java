package com.epam.filmography.service.impl;

import com.epam.filmography.exception.NotFoundException;
import com.epam.filmography.model.Actor;
import com.epam.filmography.repository.ActorRepository;
import com.epam.filmography.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public Actor getActor(Long id) {
        return actorRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public void delete(Actor actor) {
        actorRepository.delete(actor);
    }
}