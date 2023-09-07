package org.example.movieapi.reactive.repository;

import org.example.movieapi.reactive.data.Movie;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface MovieRepository extends R2dbcRepository<Movie, Integer> {
}
