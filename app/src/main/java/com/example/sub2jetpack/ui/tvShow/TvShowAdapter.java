package com.example.sub2jetpack.ui.tvShow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sub2jetpack.R;
import com.example.sub2jetpack.data.local.entity.MovieEntity;
import com.example.sub2jetpack.data.local.entity.TvEntity;
import com.example.sub2jetpack.ui.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class    TvShowAdapter extends PagedListAdapter<TvEntity, TvShowAdapter.ViewHolder> {

    protected TvShowAdapter() {
        super(DIFF_CALLBACK);
    }

    private static DiffUtil.ItemCallback<TvEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TvEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull TvEntity oldItem, @NonNull TvEntity newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull TvEntity oldItem, @NonNull TvEntity newItem) {
                    return oldItem == newItem;
                }
            };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TvEntity dataTvShow = getItem(position);
        Log.d(TAG, "onBindViewHolder: TVSHOW_ADAPTER "+getItemCount());
        if (dataTvShow != null) {
            holder.bind(dataTvShow);
        }
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final ImageView imageView;
        final CardView cardView;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_item_grid);
            cardView = itemView.findViewById(R.id.cardview_grid_container);
        }

        void bind(TvEntity data){
            Glide.with(itemView.getContext())
                    .load(data.getPosterPath())
                    .into(imageView);
            cardView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.ITEM_CODE, DetailActivity.TV_SHOW);
                intent.putExtra(DetailActivity.ID, data.getId());

                itemView.getContext().startActivity(intent);
            });
        }
    }
}
