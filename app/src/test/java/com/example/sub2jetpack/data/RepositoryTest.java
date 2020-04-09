package com.example.sub2jetpack.data;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.sub2jetpack.data.local.entity.MovieEntity;
import com.example.sub2jetpack.data.local.entity.TvEntity;
import com.example.sub2jetpack.data.remote.RemoteDataSource;
import com.example.sub2jetpack.data.remote.response.MovieResponse;
import com.example.sub2jetpack.data.remote.response.TvResponse;
import com.example.sub2jetpack.utils.DataDummy;
import com.example.sub2jetpack.utils.LiveDataTestUtil;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

public class RepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private final RemoteDataSource remoteDataSource = Mockito.mock(RemoteDataSource.class);
    private final FakeRepository fakeRepository = new FakeRepository(remoteDataSource);

    private final ArrayList<MovieResponse> movieResponses = DataDummy.generateRemoteDummyMovie();
    private final ArrayList<TvResponse> tvResponses = DataDummy.generateRemoteDummyTv();

    @Test
    public void getAllMovieUpComing(){
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadMovieCallback) invocation.getArguments()[0])
                    .onAllMoviesReceived(movieResponses);
            return null;
        }).when(remoteDataSource).getAllMoviesUpcoming(any(RemoteDataSource.LoadMovieCallback.class));
        List<MovieEntity> movieEntities = LiveDataTestUtil.getValue(fakeRepository.getAllMoviesUpcoming());
        verify(remoteDataSource).getAllMoviesUpcoming(any(RemoteDataSource.LoadMovieCallback.class));
        assertNotNull(movieEntities);
        assertEquals(movieResponses.size(),movieEntities.size());
    }

    @Test
    public void getAllMoviePlaying(){
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadMovieCallback) invocation.getArguments()[0])
                    .onAllMoviesReceived(movieResponses);
            return null;
        }).when(remoteDataSource).getAllMoviesPlaying(any(RemoteDataSource.LoadMovieCallback.class));
        List<MovieEntity> movieEntities = LiveDataTestUtil.getValue(fakeRepository.getAllMoviesPlaying());
        verify(remoteDataSource).getAllMoviesPlaying(any(RemoteDataSource.LoadMovieCallback.class));
        assertNotNull(movieEntities);
        assertEquals(movieResponses.size(), movieEntities.size());
    }

    @Test
    public void getAllTvShows(){
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadTvShowCallback) invocation.getArguments()[0])
                    .onAllTvShowReceived(tvResponses);
            return null;
        }).when(remoteDataSource).getAllTvShow(any(RemoteDataSource.LoadTvShowCallback.class));
        List<TvEntity> tvEntities = LiveDataTestUtil.getValue(fakeRepository.getAllTvShows());
        verify(remoteDataSource).getAllTvShow(any(RemoteDataSource.LoadTvShowCallback.class));
        assertNotNull(tvEntities);
        assertEquals(tvResponses.size(), tvEntities.size());
    }
}