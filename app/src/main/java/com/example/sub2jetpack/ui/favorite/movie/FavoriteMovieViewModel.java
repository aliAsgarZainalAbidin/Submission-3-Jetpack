package com.example.sub2jetpack.ui.favorite.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.example.sub2jetpack.data.Repository;
import com.example.sub2jetpack.data.local.entity.MovieEntity;

public class FavoriteMovieViewModel extends ViewModel {
    private final Repository repository;

    public FavoriteMovieViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<PagedList<MovieEntity>> getBookmarkedMovies (){
        return repository.getBookmarkedMovies();
    }
}
