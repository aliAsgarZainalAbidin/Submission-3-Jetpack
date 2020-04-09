package com.example.sub2jetpack.ui.tvShow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.sub2jetpack.data.Repository;
import com.example.sub2jetpack.data.local.entity.TvEntity;
import com.example.sub2jetpack.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvViewModelTest {
    private TvViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Repository repository;

    @Mock
    private Observer<List<TvEntity>> observer;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        viewModel = new TvViewModel(repository);
    }

    @Test
    public void getTvShow(){
        ArrayList<TvEntity> dataDummy = DataDummy.generateDummyTv();
        MutableLiveData<List<TvEntity>> dataTv = new MutableLiveData<>();
        dataTv.setValue(dataDummy);

        when(repository.getAllTvShows()).thenReturn(dataTv);
        List<TvEntity> tvEntities = viewModel.getAllTvShow().getValue();
        verify(repository).getAllTvShows();
        assertNotNull(tvEntities);

        viewModel.getAllTvShow().observeForever(observer);
        verify(observer).onChanged(dataDummy);
    }
}