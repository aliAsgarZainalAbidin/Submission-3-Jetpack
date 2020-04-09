package com.example.sub2jetpack.data.remote;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sub2jetpack.data.remote.response.MovieResponse;
import com.example.sub2jetpack.data.remote.response.TvResponse;
import com.example.sub2jetpack.utils.ExpressoIdlingResource;
import com.example.sub2jetpack.utils.JsonHelper;

import java.util.List;

public class RemoteDataSource {

    private static RemoteDataSource INSTANCE;
    private final JsonHelper jsonHelper;


    public RemoteDataSource(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;

    }

    public static RemoteDataSource getINSTANCE(JsonHelper jsonHelper) {
        if (INSTANCE==null){
            INSTANCE = new RemoteDataSource(jsonHelper);
        }
        return INSTANCE;
    }

    public void getAllMoviesUpcoming(LoadMovieCallback callback){
        ExpressoIdlingResource.increment();
        jsonHelper.loadMovieUpcoming(callback);
        ExpressoIdlingResource.decrement();
    }

    public LiveData<ApiResponse<List<MovieResponse>>> getAllMoviesUpcomingResponse(LoadMovieResponseCallback callback){
        ExpressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<MovieResponse>>> resultResponse = new MutableLiveData<>();
        resultResponse.setValue(ApiResponse.success(jsonHelper.loadMovieUpcomingResponse(callback)));
        ExpressoIdlingResource.decrement();
        return resultResponse;
    }

    public void getAllMoviesPlaying(LoadMovieCallback callback){
        ExpressoIdlingResource.increment();
        jsonHelper.loadMoviePlaying(callback);
        ExpressoIdlingResource.decrement();
    }

    public void getAllMoviesPlayingResponse(LoadMovieResponseCallback callback){
        ExpressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<MovieResponse>>> resultResponse = new MutableLiveData<>();
        resultResponse.setValue(ApiResponse.success(jsonHelper.loadMoviePlayingResponse(callback)));
        ExpressoIdlingResource.decrement();
    }

    public void getAllTvShow(LoadTvShowCallback callback){
        ExpressoIdlingResource.increment();
        jsonHelper.loadTvShow(callback);
        ExpressoIdlingResource.decrement();
    }

    public void getAllTvShowResponse(LoadTvShowResponseCallback callback){
        ExpressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<TvResponse>>> resultResponse = new MutableLiveData<>();
        resultResponse.setValue(ApiResponse.success(jsonHelper.loadTvShowResponse(callback)));
        ExpressoIdlingResource.decrement();
    }

    public interface LoadMovieCallback {
        void onAllMoviesReceived(List<MovieResponse> list);
    }

    public interface LoadTvShowCallback {
        void onAllTvShowReceived(List<TvResponse> list);
    }

    public interface LoadMovieResponseCallback {
        void onAllMoviesReceived(ApiResponse<List<MovieResponse>> list);
    }

    public interface LoadTvShowResponseCallback {
        void onAllTvShowReceived(ApiResponse<List<TvResponse>> list);
    }
}
