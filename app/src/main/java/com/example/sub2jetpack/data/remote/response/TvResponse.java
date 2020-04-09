package com.example.sub2jetpack.data.remote.response;

public class TvResponse {
    private long id;
    private String originalName;
    private String name;
    private long popularity;
    private int voteCount;
    private String firstAirDate;
    private String backdropPath;
    private String originalLanguage;
    private String overview;
    private String posterPath;
    private float voteAverage;

    public TvResponse(long id, String originalName, String name, long popularity, int voteCount, String firstAirDate, String backdropPath, String originalLanguage, String overview, String posterPath,float voteAverage) {
        this.id = id;
        this.originalName = originalName;
        this.name = name;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.firstAirDate = firstAirDate;
        this.backdropPath ="https://image.tmdb.org/t/p/original/"+ backdropPath;
        this.originalLanguage = originalLanguage;
        this.overview = overview;
        this.posterPath = "https://image.tmdb.org/t/p/original/"+posterPath;
        this.voteAverage = voteAverage;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
}
