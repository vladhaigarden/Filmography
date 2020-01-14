package com.epam.filmography.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents Movie.
 *
 * @author Vladyslav Tereshkevych
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "actors")
@ToString(callSuper = true, exclude = "actors")
@Entity
public class Movie extends BaseEntity {

    @JsonView(Views.needField.class)
    private String name;

    @Enumerated(EnumType.STRING)
    @JsonView(Views.needField.class)
    private Genre genre;

    @JsonView(Views.needField.class)
    private BigDecimal budget;

    @JsonView(Views.Actors.class)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "actor_movie",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    private Set<Actor> actors;

    public Movie() {
    }
}