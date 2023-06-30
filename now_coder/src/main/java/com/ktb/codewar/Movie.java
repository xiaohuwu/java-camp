package com.ktb.codewar;

public class Movie {
    String title;

    public Movie(String lord_of_the_rings) {
        this.title = lord_of_the_rings;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                '}';
    }
}
