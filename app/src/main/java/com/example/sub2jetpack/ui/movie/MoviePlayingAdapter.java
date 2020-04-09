package com.example.sub2jetpack.ui.movie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sub2jetpack.R;
import com.example.sub2jetpack.data.local.entity.MovieEntity;
import com.example.sub2jetpack.ui.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MoviePlayingAdapter extends PagedListAdapter<MovieEntity, MoviePlayingAdapter.ViewHolder> {


    MoviePlayingAdapter(){
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<MovieEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MovieEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
                    Log.d(TAG, "areItemsTheSame: "+oldItem.getId()+" == "+ newItem.getId() );
                    return oldItem.getId() == newItem.getId();
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        MovieEntity movie = getItem(position);
        if (movie != null) {
            holder.bind(movie);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final ImageView imageView;
        final TextView tvTitle;
        final ConstraintLayout constraintLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_item);
            tvTitle = itemView.findViewById(R.id.tv_title);
            constraintLayout = itemView.findViewById(R.id.cl_items);
        }

        void bind(MovieEntity data){
            Log.d(TAG, "bind: "+data.getTitle());
            tvTitle.setText(data.getTitle());
            Glide.with(itemView.getContext())
                    .load(data.getPosterPath())
                    .into(imageView);

            constraintLayout.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.ITEM_CODE,  DetailActivity.MOVIE);
                intent.putExtra(DetailActivity.ID, data.getId());

                itemView.getContext().startActivity(intent);
            });
        }
    }

}
