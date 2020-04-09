package com.example.sub2jetpack.ui.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.sub2jetpack.data.Repository;
import com.example.sub2jetpack.data.local.entity.MovieEntity;
import com.example.sub2jetpack.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class MovieViewModelTest {
    private MovieViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Repository repository;

    @Mock
    private Observer<List<MovieEntity>> observer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        viewModel = new MovieViewModel(repository);
    }

    @Test
    public void getMoviesUpcoming() {
        ArrayList<MovieEntity> dataDummy = DataDummy.generateDummyMovie();
        MutableLiveData<List<MovieEntity>> dataMovie = new MutableLiveData<>();
        dataMovie.setValue(dataDummy);

        Mockito.when(repository.getAllMoviesUpcoming()).thenReturn(dataMovie);
        List<MovieEntity> movieEntities = viewModel.getMoviesUpcoming().getValue();
        verify(repository).getAllMoviesUpcoming();
        assertNotNull(movieEntities);

        viewModel.getMoviesUpcoming().observeForever(observer);
        verify(observer).onChanged(dataDummy);
    }

    @Test
    public void getMoviesPlaying() {
        ArrayList<MovieEntity> dataDummy = DataDummy.generateDummyMovie();
        MutableLiveData<List<MovieEntity>> dataMovie = new MutableLiveData<>();
        dataMovie.setValue(dataDummy);

        Mockito.when(repository.getAllMoviesPlaying()).thenReturn(dataMovie);
        List<MovieEntity> movieEntities = viewModel.getMoviesPlaying().getValue();
        verify(repository).getAllMoviesPlaying();
        assertNotNull(movieEntities);

        viewModel.getMoviesPlaying().observeForever(observer);
        verify(observer).onChanged(dataDummy);
    }

}