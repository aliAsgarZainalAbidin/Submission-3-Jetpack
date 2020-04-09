package com.example.sub2jetpack.ui.favorite.tvshow;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import com.example.sub2jetpack.data.local.entity.TvEntity;
import com.example.sub2jetpack.ui.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;

public class FavoriteTvShowAdapter extends PagedListAdapter<TvEntity, FavoriteTvShowAdapter.ViewHolder> {


    protected FavoriteTvShowAdapter() {
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
                    return oldItem.equals(newItem);
                }
            };


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        TvEntity data = getItem(position);
        if (data != null) {
            holder.bind(data);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView imageView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview_grid_container);
            imageView = itemView.findViewById(R.id.img_item_grid);
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
