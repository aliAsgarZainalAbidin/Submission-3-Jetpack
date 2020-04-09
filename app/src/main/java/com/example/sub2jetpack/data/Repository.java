package com.example.sub2jetpack.data;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.sub2jetpack.data.local.LocalDataSource;
import com.example.sub2jetpack.data.local.entity.MovieEntity;
import com.example.sub2jetpack.data.local.entity.TvEntity;
import com.example.sub2jetpack.data.remote.ApiResponse;
import com.example.sub2jetpack.data.remote.RemoteDataSource;
import com.example.sub2jetpack.data.remote.response.MovieResponse;
import com.example.sub2jetpack.data.remote.response.TvResponse;
import com.example.sub2jetpack.utils.AppExecutors;
import com.example.sub2jetpack.vo.Resource;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

public class Repository implements DataSource {

    private volatile static Repository INSTANCE;

    private final RemoteDataSource remoteDataSource;
    private final LocalDataSource localDataSource;
    private final AppExecutors appExecutors;

    private Repository(@NonNull RemoteDataSource remoteDataSource,@NonNull LocalDataSource localDataSource, AppExecutors appExecutors) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.appExecutors = appExecutors;
    }


    public static Repository getInstance(RemoteDataSource remoteDataSource,LocalDataSource localDataSource, AppExecutors appExecutors) {
        if (INSTANCE==null){
            synchronized (Repository.class){
                if (INSTANCE==null){
                    INSTANCE = new Repository(remoteDataSource,localDataSource, appExecutors);
                }
            }
        }
        return INSTANCE;
    }

    public LiveData<List<MovieEntity>> getMovieWithId(String id){
        return localDataSource.getMovieWithId(id);
    }

    public LiveData<List<TvEntity>> getTvShowWithId(String id){
        return localDataSource.getTvShowWithId(id);
    }

    @Override
    public LiveData<Resource<PagedList<MovieEntity>>> getAllMoviesUpcoming() {
        return new NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors){

            @Override
            protected LiveData<PagedList<MovieEntity>> loadFromDB() {
                PagedList.Config config = new PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(15)
                        .setPageSize(5)
                        .build();
                return new LivePagedListBuilder<>(localDataSource.getAllMovies(), config).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<MovieEntity> data) {
                return (data == null) || (data.size()==0);
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                MutableLiveData<ApiResponse<List<MovieResponse>>> liveData = new MutableLiveData<>();
                remoteDataSource.getAllMoviesUpcomingResponse(liveData::postValue);
                return liveData;
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {
                ArrayList<MovieEntity> movieEntities = new ArrayList<>();
                for (MovieResponse response : data){
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
                localDataSource.insertMovies(movieEntities);
            }
        }.asLiveData();
    }


    public LiveData<Resource<PagedList<MovieEntity>>> getAllMoviesPlaying(){
        return new NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors){

            @Override
            protected LiveData<PagedList<MovieEntity>> loadFromDB() {
                PagedList.Config config = new PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(15)
                        .setPageSize(5)
                        .build();
                return new LivePagedListBuilder<>(localDataSource.getAllMovies(), config).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<MovieEntity> data) {
                return (data == null) || (data.size()==0);
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                MutableLiveData<ApiResponse<List<MovieResponse>>> liveData = new MutableLiveData<>();
                remoteDataSource.getAllMoviesPlayingResponse(liveData::postValue);
                return liveData;
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {
                ArrayList<MovieEntity> movieEntities = new ArrayList<>();
                for (MovieResponse response : data){
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
                    Log.d(TAG, "saveCallResult: "+movieEntity.getTitle());
                    movieEntities.add(movieEntity);
                }
                localDataSource.insertMovies(movieEntities);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<PagedList<TvEntity>>> getAllTvShows() {
        return new NetworkBoundResource<PagedList<TvEntity>, List<TvResponse>>(appExecutors){

            @Override
            protected LiveData<PagedList<TvEntity>> loadFromDB() {
                PagedList.Config config = new PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(27)
                        .setPageSize(9)
                        .build();
                return new LivePagedListBuilder<>(localDataSource.getAllTvShow(), config).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<TvEntity> data) {
                return (data == null) || (data.size()==0);
            }

            @Override
            protected LiveData<ApiResponse<List<TvResponse>>> createCall() {
                MutableLiveData<ApiResponse<List<TvResponse>>> liveData = new MutableLiveData<>();
                remoteDataSource.getAllTvShowResponse(liveData::postValue);
                return liveData;
            }

            @Override
            protected void saveCallResult(List<TvResponse> data) {
                ArrayList<TvEntity> tvEntities = new ArrayList<>();
                for (TvResponse response : data){
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
                    Log.d(TAG, "saveCallResult: "+tvEntity.getName());
                    tvEntities.add(tvEntity);
                }
                localDataSource.insertTvShow(tvEntities);
            }
        }.asLiveData();
    }

    @Override
    public void setMovieBookmark(MovieEntity movieEntity, boolean state) {
        appExecutors.diskIO().execute(() -> localDataSource.setMovieBookmark(movieEntity, state));
    }

    @Override
    public void setTvBookmark(TvEntity tvEntity, boolean state) {
        appExecutors.diskIO().execute(() -> localDataSource.setTvShowBookmark(tvEntity, state));
    }

    @Override
    public LiveData<PagedList<MovieEntity>> getBookmarkedMovies() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(15)
                .setPageSize(5)
                .build();
        return new LivePagedListBuilder<>(localDataSource.getBookmarkedMovies(), config).build();
    }

    @Override
    public LiveData<PagedList<TvEntity>> getBookmarkedTvShows() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(27)
                .setPageSize(9)
                .build();

        return new LivePagedListBuilder<>(localDataSource.getBookmarkedTvShow(), config).build();
    }

    public LiveData<PagedList<MovieEntity>> getAllMovies(){
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build();

        return new LivePagedListBuilder<>(localDataSource.getAllMovies(), config).build();
    }


}
