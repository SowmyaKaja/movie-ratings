package io.javabrains.ratingdataservice.resource;

import io.javabrains.ratingdataservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ratingdata")
public class RatingDataService {
    @RequestMapping("/{movieId}")
    public Rating getRatingData(@PathVariable ("movieId") String movieId) {
        return new Rating(movieId, 5);


    }
}