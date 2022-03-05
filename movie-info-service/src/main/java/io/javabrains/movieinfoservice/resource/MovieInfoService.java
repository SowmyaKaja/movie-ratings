package io.javabrains.movieinfoservice.resource;

import io.javabrains.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieInfoService {
@RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable ("movieId") String movieId) {
    if (movieId.equalsIgnoreCase("1234")) {
        return new Movie(movieId, "Interstellar");
    } else if (movieId.equalsIgnoreCase("2344")) {
        return new Movie(movieId, "Rab ne Bana di Jodi");
    } else if (movieId.equalsIgnoreCase("3456")) {
        return new Movie(movieId, "Gopala Gopala");
    } else {
        return new Movie(movieId, "Aarya");
    }
}
}
