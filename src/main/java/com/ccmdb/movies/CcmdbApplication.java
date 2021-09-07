package com.ccmdb.movies;

import com.ccmdb.movies.entity.Movie;
import com.ccmdb.movies.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class CcmdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(CcmdbApplication.class, args);
    }

    @Bean
    public CommandLineRunner testData(MovieRepository repository) {
        return (args) -> {
            // save a few movies
            repository.save(
                    Movie.builder()
                            .title("The Shawshank Redemption")
                            .genre("Drama")
                            .rating(8)
                            .releaseYear(1994)
                            .build());

            repository.save(
                    Movie.builder()
                            .title("The Godfather")
                            .genre("Drama")
                            .rating(9)
                            .releaseYear(1972)
                            .build());
            repository.save(
                    Movie.builder()
                            .title("The Dark Knight")
                            .genre("Drama")
                            .rating(7)
                            .releaseYear(2008)
                            .build());

            repository.save(
                    Movie.builder()
                            .title("Inception")
                            .genre("Action")
                            .rating(2)
                            .releaseYear(2010)
                            .build());

            repository.save(
                    Movie.builder()
                            .title("Toy Story")
                            .genre("Family")
                            .rating(10)
                            .releaseYear(1995)
                            .build());


            // Fetch all movies
            log.info("Movies added to database:");
            log.info("-------------------------------");
            repository.findAll().forEach(movie -> log.info(movie.toString()));
            log.info("");

        };
    }

}
