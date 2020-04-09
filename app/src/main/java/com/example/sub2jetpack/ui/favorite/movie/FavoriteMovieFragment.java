package com.example.sub2jetpack.ui.favorite.movie;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sub2jetpack.R;
import com.example.sub2jetpack.data.local.entity.MovieEntity;
import com.example.sub2jetpack.viewmodel.ViewModelFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteMovieFragment extends Fragment {

    private RecyclerView recyclerView;

    public FavoriteMovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_favoritemovie);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity()!=null){
            ViewModelFactory viewModelFactory = ViewModelFactory.getINSTANCE(getActivity());
            FavoriteMovieViewModel favoriteMovieViewModel = new ViewModelProvider(this, viewModelFactory).get(FavoriteMovieViewModel.class);

            FavoriteMovieAdapter favoriteMovieAdapter = new FavoriteMovieAdapter();
            favoriteMovieViewModel.getBookmarkedMovies().observe(this, movieEntities -> {
                favoriteMovieAdapter.submitList(movieEntities);
                favoriteMovieAdapter.notifyDataSetChanged();
            });

            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(favoriteMovieAdapter);
        }
    }
}
