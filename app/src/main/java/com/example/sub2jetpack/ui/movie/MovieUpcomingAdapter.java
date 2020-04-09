package com.example.sub2jetpack.ui.movie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.example.sub2jetpack.R;
import com.example.sub2jetpack.data.local.entity.MovieEntity;
import com.example.sub2jetpack.ui.detail.DetailActivity;
import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MovieUpcomingAdapter extends PagedListAdapter<MovieEntity, MovieUpcomingAdapter.ViewHolder> {

    MovieUpcomingAdapter(){
        super(DIFF_CALLBACK);
    }

    private static DiffUtil.ItemCallback<MovieEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MovieEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
                    return (oldItem.getId() == newItem.getId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
                    return oldItem == newItem;
                }
            };


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_upcoming,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        MovieEntity movieEntity = getItem(position);
        Log.d(TAG, "onBindViewHolder: "+getItemCount());
        if (movieEntity != null) {
            holder.bind(movieEntity);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final ConstraintLayout constraintLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_item_upcoming);
            constraintLayout = itemView.findViewById(R.id.constraint_grid_container);
        }

        void bind(MovieEntity items){
            Glide.with(itemView.getContext())
                    .load(items.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_autorenew_black_24dp).error(R.drawable.ic_error_black_24dp))
                    .into(imageView);

            constraintLayout.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.ITEM_CODE,  DetailActivity.MOVIE);
                intent.putExtra(DetailActivity.ID, items.getId());

                itemView.getContext().startActivity(intent);
            });
        }
    }
}
