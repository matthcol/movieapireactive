package org.example.movieapi.reactive.controller;

import lombok.Getter;
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
    public Flux<String> topMovies(){
        return Flux.empty();
    }

    @GetMapping("{id}")
    public Mono<String> getById(@PathVariable("id") int id){
        return Mono.just("Barbie");
    }
}
