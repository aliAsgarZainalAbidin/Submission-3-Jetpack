package com.example.sub2jetpack.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sub2jetpack.R;
import com.example.sub2jetpack.ui.favorite.FavoriteFragment;
import com.example.sub2jetpack.ui.movie.MovieFragment;
import com.example.sub2jetpack.ui.tvShow.TvFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private BottomNavigationView bottomNavigationView;
    public static final String FRAGMENT_MOVIES = "fragment_movies";
    public static final String FRAGMENT_TV = "fragment_tv";
    public static final String FRAGMENT= "fragment";

    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNavigationView = view.findViewById(R.id.bottom_navbar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState==null){
            setFragment(new MovieFragment());
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            Fragment fragment;
            switch (menuItem.getItemId()){
                case R.id.movie : {
                    fragment = new MovieFragment();
                    break;
                }
                case R.id.tvShow : {
                    fragment = new TvFragment();
                    break;
                }
                case R.id.favorite : {
                    fragment = new FavoriteFragment();
                    break;
                }
                default: fragment = null;
            }
            setFragment(fragment);
            return true;
        });
    }

    private void setFragment(Fragment fragment){
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_home,fragment)
                .commit();
    }
}
