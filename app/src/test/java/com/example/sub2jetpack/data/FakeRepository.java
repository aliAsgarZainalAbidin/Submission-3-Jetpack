package com.example.sub2jetpack.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sub2jetpack.data.local.entity.MovieEntity;
import com.example.sub2jetpack.data.local.entity.TvEntity;
import com.example.sub2jetpack.data.remote.RemoteDataSource;
import com.example.sub2jetpack.data.remote.response.MovieResponse;
import com.example.sub2jetpack.data.remote.response.TvResponse;

import java.util.ArrayList;
import java.util.List;

public class FakeRepository implements DataSource {

    private final RemoteDataSource remoteDataSource;

    FakeRepository(@NonNull RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }


    @Override
    public LiveData<List<MovieEntity>> getAllMoviesUpcoming() {
        MutableLiveData<List<MovieEntity>> listMovie = new MutableLiveData<>();
        remoteDataSource.getAllMoviesUpcoming(list -> {
            List<MovieEntity> movieEntityList = new ArrayList<>();
            for (MovieResponse response : list){
                MovieEntity movieEntity = new MovieEntity(response.getId(),
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
                movieEntityList.add(movieEntity);
            }
            listMovie.postValue(movieEntityList);
        });
        return listMovie;
    }

    public LiveData<List<MovieEntity>> getAllMoviesPlaying(){
        MutableLiveData<List<MovieEntity>> listMovie = new MutableLiveData<>();
        remoteDataSource.getAllMoviesPlaying(list -> {
            List<MovieEntity> movieEntities = new ArrayList<>();
            for(MovieResponse response : list){
                MovieEntity movieEntity = new MovieEntity(response.getId(),
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
                movieEntities.add(movieEntity);
            }
            listMovie.postValue(movieEntities);
        });
        return listMovie;
    }

    @Override
    public LiveData<List<TvEntity>> getAllTvShows() {
        MutableLiveData<List<TvEntity>> listTvShow = new MutableLiveData<>();
        remoteDataSource.getAllTvShow(list -> {
            ArrayList<TvEntity> tvEntities = new ArrayList<>();
            for (TvResponse response : list){
                TvEntity tvEntity = new TvEntity(response.getId(),
                        response.getOriginalName(),
                        response.getName(),
                        response.getPopularity(),
                        response.getVoteCount(),
                        response.getFirstAirDate(),
                        response.getBackdropPath(),
                        response.getOriginalLanguage(),
                        response.getOverview(),
                        response.getPosterPath(),
                        response.getVoteAverage(),
                        false);
                tvEntities.add(tvEntity);
            }
            listTvShow.postValue(tvEntities);
        });
        return listTvShow;
    }
}
