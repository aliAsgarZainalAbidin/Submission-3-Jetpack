package com.example.sub2jetpack.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.example.sub2jetpack.data.Repository;
import com.example.sub2jetpack.data.local.entity.MovieEntity;
import com.example.sub2jetpack.vo.Resource;

public class MovieViewModel extends ViewModel {
    private final Repository repository;


    public MovieViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<Resource<PagedList<MovieEntity>>> getMoviesUpcoming(){
        return repository.getAllMoviesUpcoming();
    }

    public LiveData<Resource<PagedList<MovieEntity>>> getMoviesPlaying(){
        return repository.getAllMoviesPlaying();
    }
}
