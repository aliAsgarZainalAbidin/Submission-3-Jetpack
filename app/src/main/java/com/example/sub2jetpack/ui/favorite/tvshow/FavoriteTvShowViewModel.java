package com.example.sub2jetpack.ui.favorite.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.example.sub2jetpack.data.Repository;
import com.example.sub2jetpack.data.local.entity.TvEntity;

public class FavoriteTvShowViewModel extends ViewModel {
    private final Repository repository;

    public FavoriteTvShowViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<PagedList<TvEntity>> getBookmarkedTvShow(){
        return repository.getBookmarkedTvShows();
    }
}
