package com.example.sub2jetpack.data.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.sub2jetpack.data.remote.response.MovieResponse;

import java.util.ArrayList;

@Entity(tableName = "movieentities")
public class MovieEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    private long id;

    @ColumnInfo(name = "popularity")
    private long popularity;

    @ColumnInfo(name = "voteCount")
    private int voteCount;

    @ColumnInfo(name = "video")
    private boolean video;

    @ColumnInfo(name = "posterPath")
    private String posterPath;

    @ColumnInfo(name = "adult")
    private boolean adult;

    @ColumnInfo(name = "backdropPath")
    private String backdropPath;

    @ColumnInfo(name = "originalLanguage")
    private String originalLanguage;

    @ColumnInfo(name = "originalTitle")
    private String originalTitle;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "voteAverage")
    private float voteAverage;

    @ColumnInfo(name = "overview")
    private String overview;

    @ColumnInfo(name = "releaseDate")
    private String releaseDate;

    @ColumnInfo(name = "bookmarked")
    private boolean bookmarked;

    public MovieEntity setMovieEntity(ArrayList<MovieResponse> movieResponse) {
        MovieEntity movieEntity = null;
        for (MovieResponse response : movieResponse){
            movieEntity = new MovieEntity(response.getId(),
                    response.getPopularity(),
                    response.getVoteCount(),
                    response.isVideo(),
                    response.getPosterPath(),
                    response.isAdult(),
                    response.getBackdropPath(),
                    response.getOriginalLanguage(),
                    response.getOriginalTitle(),
                    response.getTitle(),
                    response.getVoteAverage(),
                    response.getOverview(),
                    response.getReleaseDate(),
                    false);
        }
        return movieEntity;
    }

    public MovieEntity() {
    }

    public MovieEntity(long id, long popularity, int voteCount, boolean video, String posterPath, boolean adult, String backdropPath, String originalLanguage, String originalTitle, String title, float voteAverage, String overview, String releaseDate, boolean bookmarked) {
        this.id = id;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.video = video;
        this.posterPath = posterPath;
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.title = title;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.bookmarked = bookmarked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPopularity() {
        return popularity;
    }

    public void setPopularity(long popularity) {
        this.popularity = popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }
}
