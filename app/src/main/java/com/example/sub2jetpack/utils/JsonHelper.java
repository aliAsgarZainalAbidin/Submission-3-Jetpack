package com.example.sub2jetpack.utils;

import android.util.Log;


import androidx.lifecycle.MutableLiveData;

import com.example.sub2jetpack.data.remote.ApiResponse;
import com.example.sub2jetpack.data.remote.RemoteDataSource;
import com.example.sub2jetpack.data.remote.StatusResponse;
import com.example.sub2jetpack.data.remote.response.MovieResponse;
import com.example.sub2jetpack.data.remote.response.TvResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

import static android.view.View.resolveSize;
import static androidx.constraintlayout.widget.Constraints.TAG;
import static com.example.sub2jetpack.BuildConfig.API_KEY;

public class JsonHelper {

    private final AsyncHttpClient client = new AsyncHttpClient();

    public void loadMovieUpcoming(RemoteDataSource.LoadMovieCallback callback){
        List<MovieResponse> listMovie = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/movie/upcoming?api_key="+API_KEY+"&language=en-US";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String results = new String(responseBody);
                ArrayList<MovieResponse> list = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(results);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");

                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject movie = jsonArray.getJSONObject(i);
                        long id = movie.getLong("id");
                        long popularity = movie.getLong("popularity");
                        int voteCount = movie.getInt("vote_count");
                        boolean video = movie.getBoolean("video");
                        String posterPath = movie.getString("poster_path");
                        boolean adult = movie.getBoolean("adult");
                        String backdropPath = movie.getString("backdrop_path");
                        String originalLanguage = movie.getString("original_language");
                        String originalTitle = movie.getString("original_title");
                        String title = movie.getString("title");
                        float voteAverage = (float) movie.getDouble("vote_average");
                        String overview = movie.getString("overview");
                        String releaseDate = movie.getString("release_date");
                        MovieResponse movieResponse = new MovieResponse(id, popularity, voteCount, video, posterPath, adult, backdropPath, originalLanguage, originalTitle, title, voteAverage, overview, releaseDate);
                        list.add(movieResponse);
                    }
                    listMovie.addAll(list);
                    callback.onAllMoviesReceived(listMovie);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public List<MovieResponse> loadMovieUpcomingResponse(RemoteDataSource.LoadMovieResponseCallback callback){
        List<MovieResponse> listMovie = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/movie/upcoming?api_key="+API_KEY+"&language=en-US";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String results = new String(responseBody);
                ArrayList<MovieResponse> list = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(results);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");

                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject movie = jsonArray.getJSONObject(i);
                        long id = movie.getLong("id");
                        long popularity = movie.getLong("popularity");
                        int voteCount = movie.getInt("vote_count");
                        boolean video = movie.getBoolean("video");
                        String posterPath = movie.getString("poster_path");
                        boolean adult = movie.getBoolean("adult");
                        String backdropPath = movie.getString("backdrop_path");
                        String originalLanguage = movie.getString("original_language");
                        String originalTitle = movie.getString("original_title");
                        String title = movie.getString("title");
                        float voteAverage = (float) movie.getDouble("vote_average");
                        String overview = movie.getString("overview");
                        String releaseDate = movie.getString("release_date");
                        MovieResponse movieResponse = new MovieResponse(id, popularity, voteCount, video, posterPath, adult, backdropPath, originalLanguage, originalTitle, title, voteAverage, overview, releaseDate);
                        list.add(movieResponse);
                    }
                    listMovie.addAll(list);
                    ApiResponse<List<MovieResponse>> listApiResponse = new ApiResponse<>(StatusResponse.SUCCESS,listMovie,"null");
                    callback.onAllMoviesReceived(listApiResponse);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return listMovie;
    }

    public void loadMoviePlaying(RemoteDataSource.LoadMovieCallback callback){
        List<MovieResponse> listMoviePlaying = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key="+API_KEY+"&language=en-US";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String results = new String(responseBody);
                ArrayList<MovieResponse> list = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(results);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    for (int i=0 ; i<jsonArray.length();i++){
                        JSONObject dataMovie = jsonArray.getJSONObject(i);
                        long id = dataMovie.getLong("id");
                        long popularity = dataMovie.getLong("popularity");
                        int voteCount = dataMovie.getInt("vote_count");
                        boolean video = dataMovie.getBoolean("video");
                        String posterPath = dataMovie.getString("poster_path");
                        boolean adult = dataMovie.getBoolean("adult");
                        String backdropPath = dataMovie.getString("backdrop_path");
                        String originalLanguage = dataMovie.getString("original_language");
                        String originalTitle = dataMovie.getString("original_title");
                        String title = dataMovie.getString("title");
                        float voteAverage = (float) dataMovie.getDouble("vote_average");
                        String overview = dataMovie.getString("overview");
                        String releaseDate = dataMovie.getString("release_date");
                        MovieResponse movieResponse = new MovieResponse(id,
                                popularity,
                                voteCount,
                                video,
                                posterPath,
                                adult,
                                backdropPath,
                                originalLanguage,
                                originalTitle,
                                title,
                                voteAverage,
                                overview,
                                releaseDate);
                        Log.d(TAG, "onSuccess: "+movieResponse.getId());
                        list.add(movieResponse);
                    }
                    listMoviePlaying.addAll(list);
                    callback.onAllMoviesReceived(listMoviePlaying);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public List<MovieResponse> loadMoviePlayingResponse(RemoteDataSource.LoadMovieResponseCallback callback){
        List<MovieResponse> listMoviePlaying = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key="+API_KEY+"&language=en-US";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String results = new String(responseBody);
                ArrayList<MovieResponse> list = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(results);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    for (int i=0 ; i<jsonArray.length();i++){
                        JSONObject dataMovie = jsonArray.getJSONObject(i);
                        long id = dataMovie.getLong("id");
                        long popularity = dataMovie.getLong("popularity");
                        int voteCount = dataMovie.getInt("vote_count");
                        boolean video = dataMovie.getBoolean("video");
                        String posterPath = dataMovie.getString("poster_path");
                        boolean adult = dataMovie.getBoolean("adult");
                        String backdropPath = dataMovie.getString("backdrop_path");
                        String originalLanguage = dataMovie.getString("original_language");
                        String originalTitle = dataMovie.getString("original_title");
                        String title = dataMovie.getString("title");
                        float voteAverage = (float) dataMovie.getDouble("vote_average");
                        String overview = dataMovie.getString("overview");
                        String releaseDate = dataMovie.getString("release_date");
                        MovieResponse movieResponse = new MovieResponse(id,
                                popularity,
                                voteCount,
                                video,
                                posterPath,
                                adult,
                                backdropPath,
                                originalLanguage,
                                originalTitle,
                                title,
                                voteAverage,
                                overview,
                                releaseDate);
                        Log.d(TAG, "onSuccess: "+movieResponse.getTitle());
                        list.add(movieResponse);
                    }
                    listMoviePlaying.addAll(list);
                    ApiResponse<List<MovieResponse>> listApiResponse = new ApiResponse<>(StatusResponse.SUCCESS,listMoviePlaying,"null");
                    callback.onAllMoviesReceived(listApiResponse);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return listMoviePlaying;
    }

    public void loadTvShow(RemoteDataSource.LoadTvShowCallback callback){
        List<TvResponse> tvResponseList = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/tv/airing_today?api_key="+API_KEY+"&language=en-US";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String results = new String(responseBody);
                try {
                    JSONObject jsonObject = new JSONObject(results);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    ArrayList<TvResponse> list = new ArrayList<>();
                    for (int i=0; i<jsonArray.length();i++){
                        JSONObject dataTv = jsonArray.getJSONObject(i);
                        long id = dataTv.getLong("id");
                        String originalName = dataTv.getString("original_name");
                        String name = dataTv.getString("name");
                        long popularity = dataTv.getLong("popularity");
                        int voteCount = dataTv.getInt("vote_count");
                        String firstAirDate = dataTv.getString("first_air_date");
                        String backdropPath = dataTv.getString("backdrop_path");
                        String originalLanguage = dataTv.getString("original_language");
                        String overview = dataTv.getString("overview");
                        String posterPath = dataTv.getString("poster_path");
                        float voteAverage =(float) dataTv.getDouble("vote_average");
                        TvResponse response = new TvResponse(id,
                                originalName,
                                name,
                                popularity,
                                voteCount,
                                firstAirDate,
                                backdropPath,
                                originalLanguage,
                                overview,
                                posterPath,
                                voteAverage);
                        Log.d(TAG, "onSuccess: "+response.getId());
                        list.add(response);
                    }
                    tvResponseList.addAll(list);
                    callback.onAllTvShowReceived(tvResponseList);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public List<TvResponse> loadTvShowResponse(RemoteDataSource.LoadTvShowResponseCallback callback){
        List<TvResponse> tvResponseList = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/tv/airing_today?api_key="+API_KEY+"&language=en-US";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String results = new String(responseBody);
                try {
                    JSONObject jsonObject = new JSONObject(results);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    ArrayList<TvResponse> list = new ArrayList<>();
                    for (int i=0; i<jsonArray.length();i++){
                        JSONObject dataTv = jsonArray.getJSONObject(i);
                        long id = dataTv.getLong("id");
                        String originalName = dataTv.getString("original_name");
                        String name = dataTv.getString("name");
                        long popularity = dataTv.getLong("popularity");
                        int voteCount = dataTv.getInt("vote_count");
                        String firstAirDate = dataTv.getString("first_air_date");
                        String backdropPath = dataTv.getString("backdrop_path");
                        String originalLanguage = dataTv.getString("original_language");
                        String overview = dataTv.getString("overview");
                        String posterPath = dataTv.getString("poster_path");
                        float voteAverage =(float) dataTv.getDouble("vote_average");
                        TvResponse response = new TvResponse(id,
                                originalName,
                                name,
                                popularity,
                                voteCount,
                                firstAirDate,
                                backdropPath,
                                originalLanguage,
                                overview,
                                posterPath,
                                voteAverage);
                        Log.d(TAG, "onSuccess: "+response.getId());
                        list.add(response);
                    }
                    tvResponseList.addAll(list);
                    ApiResponse<List<TvResponse>> listApiResponse = new ApiResponse<>(StatusResponse.SUCCESS, tvResponseList, "null");
                    callback.onAllTvShowReceived(listApiResponse);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return tvResponseList;
    }

}
