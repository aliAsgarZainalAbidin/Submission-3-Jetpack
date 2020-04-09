package com.example.sub2jetpack.data.local.room;

import android.graphics.Movie;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sub2jetpack.data.local.entity.MovieEntity;
import com.example.sub2jetpack.data.local.entity.TvEntity;

import java.util.List;

@Dao
public interface DataDao {
    @Query("SELECT * FROM movieentities")
    DataSource.Factory<Integer, MovieEntity> getMovies();

    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    LiveData<List<MovieEntity>> getMovieWithId(String movieId);

    @Query("SELECT * FROM tventities WHERE tvId = :tvId")
    LiveData<List<TvEntity>> getTvShowWithId(String tvId);

    @Query("SELECT * FROM movieentities where bookmarked = 1 ")
    DataSource.Factory<Integer, MovieEntity> getBookmarkedMovies();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovies(List<MovieEntity> movies);

    @Update
    void updateMovies(MovieEntity movies);

    @Query("SELECT * FROM tventities")
    DataSource.Factory<Integer, TvEntity> getTvShow();

    @Query("SELECT * FROM tventities where bookmarked = 1")
    DataSource.Factory<Integer, TvEntity> getBookmarkedTvShow();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTvShow(List<TvEntity> tvShow);

    @Update
    void updateTvShow(TvEntity tvShow);


}
