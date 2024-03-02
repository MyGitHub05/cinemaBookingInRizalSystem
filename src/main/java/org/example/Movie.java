package org.example;

import java.util.List;

public class Movie {
    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getDuration() {
        return duration;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    private String title;
    private String director;
    private String duration;
    private List<Genre> genres;

    public Movie(String title, String director, String duration, List<Genre> genres){
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.genres = genres;

    }

}
