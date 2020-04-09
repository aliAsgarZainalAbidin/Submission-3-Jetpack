package com.example.sub2jetpack.ui.favorite.tvshow;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sub2jetpack.R;
import com.example.sub2jetpack.ui.favorite.movie.FavoriteMovieAdapter;
import com.example.sub2jetpack.viewmodel.ViewModelFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteTvShowFragment extends Fragment {

    private RecyclerView recyclerView;

    public FavoriteTvShowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_favoritetvshow);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity()!=null){
            ViewModelFactory factory = ViewModelFactory.getINSTANCE(getActivity());
            FavoriteTvShowViewModel favoriteTvShowViewModel = new ViewModelProvider(this, factory).get(FavoriteTvShowViewModel.class);

            FavoriteTvShowAdapter favoriteTvShowAdapter = new FavoriteTvShowAdapter();
            favoriteTvShowViewModel.getBookmarkedTvShow().observe(this,tvEntities -> {
                favoriteTvShowAdapter.submitList(tvEntities);
                favoriteTvShowAdapter.notifyDataSetChanged();
            });

            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(favoriteTvShowAdapter);
        }
    }
}
