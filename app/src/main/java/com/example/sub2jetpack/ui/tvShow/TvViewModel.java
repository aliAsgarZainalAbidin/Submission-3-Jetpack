package com.example.sub2jetpack.ui.tvShow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.example.sub2jetpack.data.Repository;
import com.example.sub2jetpack.data.local.entity.TvEntity;
import com.example.sub2jetpack.vo.Resource;

public class TvViewModel extends ViewModel {
    private final Repository repository;

    public TvViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<Resource<PagedList<TvEntity>>> getAllTvShow(){
        return repository.getAllTvShows();
    }
}
