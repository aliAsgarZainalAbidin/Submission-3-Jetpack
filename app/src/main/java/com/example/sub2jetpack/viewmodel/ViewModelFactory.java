package com.example.sub2jetpack.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.sub2jetpack.Injection.Injection;
import com.example.sub2jetpack.data.Repository;
import com.example.sub2jetpack.ui.detail.DetailViewModel;
import com.example.sub2jetpack.ui.favorite.movie.FavoriteMovieViewModel;
import com.example.sub2jetpack.ui.favorite.tvshow.FavoriteTvShowViewModel;
import com.example.sub2jetpack.ui.movie.MovieViewModel;
import com.example.sub2jetpack.ui.tvShow.TvViewModel;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final Repository repository;

    private ViewModelFactory(Repository repository) {
        this.repository = repository;
    }

    public static ViewModelFactory getINSTANCE(Context context) {
        if (INSTANCE==null){
            synchronized (ViewModelFactory.class){
                if (INSTANCE==null){
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(context));
                    Log.d(TAG, "getINSTANCE: BOM HERE");
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieViewModel.class)){
            return (T) new MovieViewModel(repository);
        } else if (modelClass.isAssignableFrom(TvViewModel.class)){
            return (T) new TvViewModel(repository);
        } else if (modelClass.isAssignableFrom(DetailViewModel.class)){
            return (T) new DetailViewModel(repository);
        } else if (modelClass.isAssignableFrom(FavoriteMovieViewModel.class)){
            return (T) new FavoriteMovieViewModel(repository);
        } else if (modelClass.isAssignableFrom(FavoriteTvShowViewModel.class)){
            return (T) new FavoriteTvShowViewModel(repository);
        }

        throw new IllegalArgumentException("Unknown View Model Class: "+ modelClass.getName());
    }
}
