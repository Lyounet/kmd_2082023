package com.pivovarit.movies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.util.Optional;

@Configuration
class RentalStoreDevConfiguration {

    @Bean
    @Profile("dev")
    @Primary
    public MoviePriceCalculator fixedMoviePriceCalculator() {
        return movie -> 42;
    }

    @Bean
    @Profile("dev")
    @Primary
    public MovieRepository inmemoryMovieRepository() {
        return new InmemoryMovieRepository();
    }

    @Bean
    @Profile("dev")
    @Primary
    public MovieDescriptionsRepository movieDescriptionsRepository() {
        return id -> Optional.of(new MovieDescriptionsRepository.MovieDescription("lorem ipsum"));
    }
}
