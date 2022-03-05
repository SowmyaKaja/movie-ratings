package io.javabrains.ratingdataservice.models;

import java.util.List;

public class UserRating {
    public List<Rating> getGetUserRatings() {
        return getUserRatings;
    }

    public void setGetUserRatings(List<Rating> getUserRatings) {
        this.getUserRatings = getUserRatings;
    }

    private List<Rating> getUserRatings;
}
