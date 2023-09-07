package org.example.movieapi.reactive.controller;

import lombok.Getter;
import org.example.movieapi.reactive.data.Movie;
import org.example.movieapi.reactive.data.Person;
import org.example.movieapi.reactive.repository.MovieRepository;
import org.example.movieapi.reactive.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.Objects;

import static org.springframework.data.domain.Sort.Order.asc;
import static org.springframework.data.domain.Sort.Order.desc;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public Flux<Movie> topMovies(){
        //return Flux.empty();
//        return Flux.just(
//                Movie.builder()
//                        .id(1)
//                        .title("Barbie")
//                        .year((short) 2023)
//                        .build(),
//                Movie.builder()
//                        .id(2)
//                        .title("Oppenheimer")
//                        .year((short) 2023)
//                        .build()
//        );
        return movieRepository.findAll(Sort.by(desc("year"), asc("title")));
    }

    @GetMapping("{id}")
    public Mono<Movie> getById(@PathVariable("id") int id) {
//        return Mono.just(Movie.builder()
//                .id(id)
//                .title("Barbie")
//                .year((short) 2023)
//                .build());
        return movieRepository.findById(id)
                .flatMap(movie -> {
                    if (Objects.isNull(movie.getDirectorId())) {
                        return Mono.just(movie);
                    } else {
                        return personRepository.findById(movie.getDirectorId())
                                .map(movie::setDirector);  // NB: movie.setDirector returns movie
                    }
                });
    }

    @GetMapping("byTitle")
    public Flux<Movie> getByTitle(@RequestParam("t") String title){
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    @GetMapping("byTitleYear")
    public Mono<Movie> getByTitleYear(
            @RequestParam("t") String title,
            @RequestParam("y") short year
    ){
        return movieRepository.findByTitleAndYear(title, year);
    }

    @GetMapping("byYearRange")
    public Flux<Movie> getByYearRange(
            @RequestParam("ymin") short yearMin,
            @RequestParam("ymax") short yearMax
    ){
        return movieRepository.findByYearRange(yearMin, yearMax);
    }

    @PostMapping
    public Mono<Movie> add(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }
}
