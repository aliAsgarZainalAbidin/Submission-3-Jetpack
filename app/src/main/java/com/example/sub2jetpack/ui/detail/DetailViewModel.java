package com.example.sub2jetpack.ui.detail;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.example.sub2jetpack.data.Repository;
import com.example.sub2jetpack.data.local.entity.MovieEntity;
import com.example.sub2jetpack.data.local.entity.TvEntity;
import com.example.sub2jetpack.vo.Resource;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class DetailViewModel extends ViewModel {
    private final Repository repository;
    private MovieEntity movieEntity;
    private TvEntity tvEntity;

    void setMovieEntity(MovieEntity data) {
        movieEntity = data;
    }

    void setTvEntity(TvEntity data) {
        tvEntity = data;
    }

    public DetailViewModel(Repository repository) {
        this.repository = repository;
    }

    LiveData<List<MovieEntity>> getMoviesWithId(String id){
        return repository.getMovieWithId(id);
    }

    public LiveData<PagedList<MovieEntity>> getMovies(){
        return repository.getAllMovies();
    }

    LiveData<List<TvEntity>> getTvShowWithId(String id){
        return repository.getTvShowWithId(id);
    }

    void setMovieBookmark(boolean state){
        repository.setMovieBookmark(movieEntity, state);
    }

    void setTvShowBookmark(boolean state){
        repository.setTvBookmark(tvEntity, state);
    }
}
