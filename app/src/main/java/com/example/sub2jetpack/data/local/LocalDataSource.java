package com.example.sub2jetpack.data.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.example.sub2jetpack.data.local.entity.MovieEntity;
import com.example.sub2jetpack.data.local.entity.TvEntity;
import com.example.sub2jetpack.data.local.room.DataDao;

import java.util.List;

public class LocalDataSource {
    private static LocalDataSource INSTANCE;
    private final DataDao dataDao;

    public LocalDataSource(DataDao dataDao) {
        this.dataDao = dataDao;
    }

    public static LocalDataSource getInstance(DataDao dataDao){
        if (INSTANCE==null){
            INSTANCE = new LocalDataSource(dataDao);
        }
        return INSTANCE;
    }

    public DataSource.Factory<Integer, MovieEntity> getAllMovies(){
        return dataDao.getMovies();
    }

    public LiveData<List<MovieEntity>> getMovieWithId(String id){
        return dataDao.getMovieWithId(id);
    }

    public LiveData<List<TvEntity>> getTvShowWithId(String id){
        return dataDao.getTvShowWithId(id);
    }

    public DataSource.Factory<Integer, MovieEntity> getBookmarkedMovies(){
        return dataDao.getBookmarkedMovies();
    }

    public void setMovieBookmark(MovieEntity movieEntity, boolean newState){
        movieEntity.setBookmarked(newState);
        dataDao.updateMovies(movieEntity);
    }

    public void setTvShowBookmark(TvEntity tvEntity, boolean newState){
        tvEntity.setBookmarked(newState);
        dataDao.updateTvShow(tvEntity);
    }

    public void insertMovies(List<MovieEntity> movies){
        dataDao.insertMovies(movies);
    }

    public void updateMovie(MovieEntity movieEntity){
        dataDao.updateMovies(movieEntity);
    }

    public DataSource.Factory<Integer, TvEntity> getAllTvShow(){
        return dataDao.getTvShow();
    }

    public DataSource.Factory<Integer, TvEntity> getBookmarkedTvShow(){
        return dataDao.getBookmarkedTvShow();
    }

    public void insertTvShow(List<TvEntity> tvEntities){
        dataDao.insertTvShow(tvEntities);
    }

    public void updateTvShow(TvEntity tvEntity){
        dataDao.updateTvShow(tvEntity);
    }
}
