package io.javabrains.moviecatalogeservice.models;

public class CatalogItem {
    private String movie_name;
    private String movie_desc;
    private String movie_rating;

    public CatalogItem(String movie_name, String movie_desc, String movie_rating) {
        this.movie_name = movie_name;
        this.movie_desc = movie_desc;
        this.movie_rating = movie_rating;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_desc() {
        return movie_desc;
    }

    public void setMovie_desc(String movie_desc) {
        this.movie_desc = movie_desc;
    }

    public String getMovie_rating() {
        return movie_rating;
    }

    public void setMovie_rating(String movie_rating) {
        this.movie_rating = movie_rating;
    }
}
