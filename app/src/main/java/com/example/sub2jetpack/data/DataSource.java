package com.example.sub2jetpack.data;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.example.sub2jetpack.data.local.entity.MovieEntity;
import com.example.sub2jetpack.data.local.entity.TvEntity;
import com.example.sub2jetpack.vo.Resource;

import java.util.List;

interface DataSource {
    LiveData<Resource<PagedList<MovieEntity>>> getAllMoviesUpcoming();
    LiveData<Resource<PagedList<MovieEntity>>> getAllMoviesPlaying();
    LiveData<Resource<PagedList<TvEntity>>> getAllTvShows();
    void setMovieBookmark(MovieEntity movieEntity, boolean state);
    void setTvBookmark(TvEntity tvEntity, boolean state);
    LiveData<PagedList<MovieEntity>> getBookmarkedMovies();
    LiveData<PagedList<TvEntity>> getBookmarkedTvShows();
}
