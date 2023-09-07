package org.example.movieapi.reactive.repository;

import org.example.movieapi.reactive.data.Movie;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieRepository extends R2dbcRepository<Movie, Integer> {

//    @Override
//    @Query("select m.id, m.title, m.year, " +
//            "m.director_id, d.name as director_name, d.birthdate as director_birthdate " +
//            "from movies m left join persons d on m.director_id = d.id " +
//            "where m.id = :id")
//    Mono<Movie> findById(Integer id);
    Flux<Movie> findByTitleContainingIgnoreCase(String title);

    Mono<Movie> findByTitleAndYear(String title, short year);

    @Query("select m.id, m.title, m.year, m.duration " +
            "from movies m where m.year between :year1 and :year2")
    Flux<Movie> findByYearRange(short year1, short year2);
}
