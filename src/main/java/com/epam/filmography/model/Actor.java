package com.epam.filmography.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents Actor.
 *
 * @author Vladyslav Tereshkevych
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "movies")
@ToString(callSuper = true, exclude = "movies")
@Entity
public class Actor extends BaseEntity {

    @Column(name = "first_name")
    @JsonView(Views.needField.class)
    private String firstName;

    @Column(name = "last_name")
    @JsonView(Views.needField.class)
    private String lastName;

    @JsonView(Views.needField.class)
    private BigDecimal salary;

    @JsonView(Views.Movies.class)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "actor_movie",
            joinColumns = {@JoinColumn(name = "actor_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private Set<Movie> movies;

    public Actor() {
    }
}