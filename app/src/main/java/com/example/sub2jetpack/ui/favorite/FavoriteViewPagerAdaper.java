package com.example.sub2jetpack.ui.favorite;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.sub2jetpack.R;
import com.example.sub2jetpack.ui.favorite.movie.FavoriteMovieFragment;
import com.example.sub2jetpack.ui.favorite.tvshow.FavoriteTvShowFragment;

public class FavoriteViewPagerAdaper extends FragmentPagerAdapter {

    public static final int[] TAB_ITEMS = new int[]{R.string.movies, R.string.tv_show};
    private Context context;

    public FavoriteViewPagerAdaper(@NonNull FragmentManager fm, Context context) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new FavoriteMovieFragment();
            case 1 : return new FavoriteTvShowFragment();
            default: return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return TAB_ITEMS.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return context.getResources().getString(TAB_ITEMS[position]);
    }
}
