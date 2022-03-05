package io.javabrains.moviecatalogeservice.Resource;

import io.javabrains.moviecatalogeservice.models.CatalogItem;
import io.javabrains.moviecatalogeservice.models.Movie;
import io.javabrains.moviecatalogeservice.models.Rating;
import io.javabrains.moviecatalogeservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userID}")
    public List<CatalogItem> getCatalog(@PathVariable("userID") String userID) {
        //get all rated movies ID's
    UserRating ratings =restTemplate.getForObject("http://localhost:8082/ratingdata/users/" + userID, UserRating.class);


    return ratings.getGetUserRatings().stream().map(rating -> {
        // --------------restTemplate--------------------
        // for each movie ID call the movie info service and get details
        // making a call to the API and unmarshall the object.
        Movie movie = restTemplate.getForObject("http://localhost:8081/movie/" + rating.getMovieId(),
                // need ,movie id n movie name we can get that from movie class
                // by copy-paste the class in mcr it.
                Movie.class);
// put them all together.
        return new CatalogItem(movie.getName(), "very good", rating.getRating());
    }).collect(Collectors.toList());//to get the information of catalog items list and returning themcd
    }
}

/* -------------WebClientBuilder  ----------------------
       //way to use the web client. Calling the movie using the webClient.builder
        Movie movie = webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/movie/" + rating.getMovieId())
                .retrieve()
                .bodyToMono(Movie.class)
                .block();*/
