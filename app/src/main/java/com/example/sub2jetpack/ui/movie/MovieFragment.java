package com.example.sub2jetpack.ui.movie;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sub2jetpack.R;
import com.example.sub2jetpack.viewmodel.ViewModelFactory;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private RecyclerView rvUpcoming;
    private RecyclerView rvNews;
    private ProgressBar progressBar;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvUpcoming = view.findViewById(R.id.rv_upcoming);
        rvNews = view.findViewById(R.id.rv_news);
        progressBar = view.findViewById(R.id.progressbar_movie_loading);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() !=null){
            ViewModelFactory viewModelFactory = ViewModelFactory.getINSTANCE(getActivity());
            MovieViewModel movieViewModel = new ViewModelProvider(this,viewModelFactory).get(MovieViewModel.class);

            MovieUpcomingAdapter movieUpcomingAdapter = new MovieUpcomingAdapter();
            movieViewModel.getMoviesUpcoming().observe(this, movieEntities -> {
                if (movieEntities!=null){
                    switch (movieEntities.status) {
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            Log.d(TAG, "onActivityCreated: LOADING");
                            break;
                        case SUCCESS:
                            progressBar.setVisibility(View.GONE);
                            for (int i=0; i<movieEntities.data.size();i++){
                                movieEntities.data.get(i).getTitle();
                            }
                            movieUpcomingAdapter.submitList(movieEntities.data);
                            movieUpcomingAdapter.notifyDataSetChanged();
                            Log.d(TAG, "onActivityCreated: SUCCESS");
                            break;
                        case ERROR:
                            progressBar.setVisibility(View.GONE);
                            Log.d(TAG, "onActivityCreated: ERROR");
                            Toast.makeText(getContext(),"Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
            rvUpcoming.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            rvUpcoming.setHasFixedSize(true);
            rvUpcoming.setAdapter(movieUpcomingAdapter);

            MoviePlayingAdapter moviePlayingAdapter = new MoviePlayingAdapter();
            movieViewModel.getMoviesPlaying().observe(this, movieEntities -> {
                if (movieEntities != null){
                    switch (movieEntities.status) {
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            progressBar.setVisibility(View.GONE);
                            for (int i=0; i<movieEntities.data.size();i++){
                                movieEntities.data.get(i).getTitle();
                            }
                            moviePlayingAdapter.submitList(movieEntities.data);
                            moviePlayingAdapter.notifyDataSetChanged();
                            break;
                        case ERROR:
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getContext(),"Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
            rvNews.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            rvNews.setHasFixedSize(true);
            rvNews.setAdapter(moviePlayingAdapter);
        }
    }
}
