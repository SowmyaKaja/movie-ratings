package io.javabrains.ratingdataservice.resource;

import io.javabrains.ratingdataservice.models.Rating;
import io.javabrains.ratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/ratingdata")
public class RatingDataService {
    @RequestMapping("/{movieId}")
    public Rating getRatingData(@PathVariable ("movieId") String movieId) {
        return new Rating(movieId, 5);
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable ("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 3),
                new Rating("2344",5),
                new Rating("3456",4),
                new Rating("5555", 3)
        );
       UserRating userRating =  new UserRating();
        userRating.setGetUserRatings(ratings);
        return userRating;
    }
}
