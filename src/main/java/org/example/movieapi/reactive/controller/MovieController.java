package org.example.movieapi.reactive.controller;

import lombok.Getter;
import org.example.movieapi.reactive.data.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @GetMapping
    public Flux<Movie> topMovies(){
        //return Flux.empty();
        return Flux.just(
                Movie.builder()
                        .id(1)
                        .title("Barbie")
                        .year((short) 2023)
                        .build(),
                Movie.builder()
                        .id(2)
                        .title("Oppenheimer")
                        .year((short) 2023)
                        .build()
        );
    }

    @GetMapping("{id}")
    public Mono<Movie> getById(@PathVariable("id") int id){
        return Mono.just(Movie.builder()
                .id(id)
                .title("Barbie")
                .year((short) 2023)
                .build());
    }
}
