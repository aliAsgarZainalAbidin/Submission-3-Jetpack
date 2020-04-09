package com.example.sub2jetpack.ui.detail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Movie;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sub2jetpack.R;
import com.example.sub2jetpack.data.Repository;
import com.example.sub2jetpack.data.local.entity.MovieEntity;
import com.example.sub2jetpack.data.local.entity.TvEntity;
import com.example.sub2jetpack.viewmodel.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import static android.provider.MediaStore.Video.VideoColumns.LANGUAGE;

public class DetailActivity extends AppCompatActivity {

    public static final String ITEM_CODE = "item_code";
    public static final String ID = "id";
    public static final String MOVIE = "movie";
    public static final String TV_SHOW = "tv_show";

    private TextView textTitleAdult;
    private TextView textTitleDot3;
    private TextView textTitleDot4;
    private TextView textAdult;
    private TextView textVideo;
    private TextView textTitleVideo;
    private CheckBox checkBoxBookmark;
    private DetailViewModel detailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageViewBackdrop = findViewById(R.id.image_detail_backdrop);
        TextView textTitleItem = findViewById(R.id.text_detail_title_item);
        TextView textDateItem = findViewById(R.id.text_detail_date_item);
        TextView textPopularity = findViewById(R.id.text_detail_popularity_value);
        TextView textRate = findViewById(R.id.text_detail_rate_value);
        TextView textReviewers = findViewById(R.id.text_detail_reviewers);
        TextView textLanguage = findViewById(R.id.text_detail_language);
        ImageView imageViewPoster = findViewById(R.id.image_detail_poster);
        TextView textOriginalTitle = findViewById(R.id.text_detail_original_title);
        TextView textDetailTitle = findViewById(R.id.text_detail_title);
        textAdult = findViewById(R.id.text_detail_adult);
        textVideo = findViewById(R.id.text_detail_video);
        textTitleAdult = findViewById(R.id.text_detail_title_adult);
        textTitleDot3 = findViewById(R.id.text_detail_double_dot3);
        textTitleDot4 = findViewById(R.id.text_detail_double_dot4);
        textTitleVideo = findViewById(R.id.text_detail_title_video);
        checkBoxBookmark = findViewById(R.id.checkbox_detail_bookmark);
        TextView textOverview = findViewById(R.id.text_detail_overview_item);

        String itemCode = getIntent().getStringExtra(ITEM_CODE);
        String id = String.valueOf(getIntent().getLongExtra(ID, 0));

        ViewModelFactory viewModelFactory = ViewModelFactory.getINSTANCE(this);
        detailViewModel = new ViewModelProvider(this,viewModelFactory).get(DetailViewModel.class);

        if (itemCode.equals(MOVIE)){
            detailViewModel.getMoviesWithId(id).observe(this, movieEntities -> {
                boolean state = false;
                for (MovieEntity data : movieEntities){
                    Glide.with(this)
                            .load(data.getBackdropPath())
                            .into(imageViewBackdrop);
                    textTitleItem.setText(data.getTitle());
                    textDateItem.setText(data.getReleaseDate());
                    textPopularity.setText(String.valueOf(data.getPopularity()));
                    textRate.setText(String.valueOf(data.getVoteAverage()));
                    String reviewers = data.getVoteCount() + getResources().getString(R.string.reviewers_example);
                    textReviewers.setText(reviewers);
                    textLanguage.setText(data.getOriginalLanguage());
                    Glide.with(this)
                            .load(data.getPosterPath())
                            .into(imageViewPoster);
                    textOriginalTitle.setText(data.getOriginalTitle());
                    textDetailTitle.setText(data.getTitle());
                    textAdult.setText(data.isAdult() ? "Yes" : "No");
                    textVideo.setText(data.isVideo() ? "Yes" : "No");
                    textOverview.setText(data.getOverview());
                    state = data.isBookmarked();
                    detailViewModel.setMovieEntity(data);
                }
                checkBoxBookmark.setChecked(state);
            });

        } else if (itemCode.equals(TV_SHOW)){
            detailViewModel.getTvShowWithId(id).observe(this, tvEntities -> {
                boolean state = false;
                for (TvEntity data : tvEntities){
                    Glide.with(this)
                            .load(data.getBackdropPath())
                            .into(imageViewBackdrop);
                    textTitleItem.setText(data.getName());
                    textDateItem.setText(data.getFirstAirDate());
                    textPopularity.setText(String.valueOf(data.getPopularity()));
                    textRate.setText(String.valueOf(data.getVoteAverage()));
                    String reviewers = data.getVoteCount() + getResources().getString(R.string.reviewers_example);
                    textReviewers.setText(reviewers);
                    Glide.with(this)
                            .load(data.getPosterPath())
                            .into(imageViewPoster);
                    textOriginalTitle.setText(data.getOriginalName());
                    textDetailTitle.setText(data.getName());
                    setViewGone();
                    textOverview.setText(data.getOverview());
                    state = data.isBookmarked();
                    detailViewModel.setTvEntity(data);
                }
                checkBoxBookmark.setChecked(state);
            });
        }

        checkBoxBookmark.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                if (itemCode.equals(MOVIE)){
                    detailViewModel.setMovieBookmark(true);
                } else if (itemCode.equals(TV_SHOW)){
                   detailViewModel.setTvShowBookmark(true);
                }
            } else {
                if (itemCode.equals(MOVIE)){
                    detailViewModel.setMovieBookmark(false);
                } else if (itemCode.equals(TV_SHOW)){
                    detailViewModel.setTvShowBookmark(false);
                }
            }
        });
    }

    private void setViewGone() {
        textTitleAdult.setVisibility(View.GONE);
        textTitleVideo.setVisibility(View.GONE);
        textAdult.setVisibility(View.GONE);
        textVideo.setVisibility(View.GONE);
        textTitleDot4.setVisibility(View.GONE);
        textTitleDot3.setVisibility(View.GONE);
    }

}
