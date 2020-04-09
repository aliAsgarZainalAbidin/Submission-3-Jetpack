package com.example.sub2jetpack.ui.favorite;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sub2jetpack.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager =  view.findViewById(R.id.viewpager_favorite_container);
        tabLayout = view.findViewById(R.id.tab_favorite_container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity()!=null){
            FavoriteViewPagerAdaper viewPagerAdaper = new FavoriteViewPagerAdaper(getChildFragmentManager(),getContext());
            viewPager.setAdapter(viewPagerAdaper);
            tabLayout.setupWithViewPager(viewPager);
        }
    }
}
