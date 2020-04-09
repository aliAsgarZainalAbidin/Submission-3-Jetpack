package com.example.sub2jetpack.data.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tventities")
public class TvEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvId")
    private long id;

    @ColumnInfo(name = "originalName")
    private String originalName;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "popularity")
    private long popularity;

    @ColumnInfo(name = "voteCount")
    private int voteCount;

    @ColumnInfo(name = "firstAirDate")
    private String firstAirDate;

    @ColumnInfo(name = "backdropPath")
    private String backdropPath;

    @ColumnInfo(name = "originalLanguage")
    private String originalLanguage;

    @ColumnInfo(name = "overview")
    private String overview;

    @ColumnInfo(name = "posterPath")
    private String posterPath;

    @ColumnInfo(name = "voteAverage")
    private float voteAverage;

    @ColumnInfo(name = "bookmarked")
    private boolean bookmarked;

    public TvEntity(long id, String originalName, String name, long popularity, int voteCount, String firstAirDate, String backdropPath, String originalLanguage, String overview, String posterPath,float voteAverage, boolean bookmarked) {
        this.id = id;
        this.originalName = originalName;
        this.name = name;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.firstAirDate = firstAirDate;
        this.backdropPath = backdropPath;
        this.originalLanguage = originalLanguage;
        this.overview = overview;
        this.posterPath = posterPath;
        this.voteAverage = voteAverage;
        this.bookmarked = bookmarked;
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

    public boolean isBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }
}
