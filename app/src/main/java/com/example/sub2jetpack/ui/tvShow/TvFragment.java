package com.example.sub2jetpack.ui.tvShow;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sub2jetpack.R;
import com.example.sub2jetpack.viewmodel.ViewModelFactory;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment {

    private RecyclerView rvTvShow;
    private ProgressBar progressBar;

    public TvFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTvShow = view.findViewById(R.id.rv_tv_show);
        progressBar = view.findViewById(R.id.progressbar_tvshow_loading);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity()!=null){
            ViewModelFactory viewModelFactory = ViewModelFactory.getINSTANCE(getActivity());
            TvViewModel tvViewModel = new ViewModelProvider(this,viewModelFactory).get(TvViewModel.class);

            TvShowAdapter tvShowAdapter = new TvShowAdapter();
            tvViewModel.getAllTvShow().observe(this,tvEntities -> {
                if (tvEntities != null){
                    switch (tvEntities.status){
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            Log.d(TAG, "onActivityCreated: LOADING");
                            break;
                        case SUCCESS:
                            progressBar.setVisibility(View.GONE);
                            tvShowAdapter.submitList(tvEntities.data);
                            tvShowAdapter.notifyDataSetChanged();
                            Log.d(TAG, "onActivityCreated: SUCCESS");
                            break;
                        case ERROR:
                            progressBar.setVisibility(View.GONE);
                            Log.d(TAG, "onActivityCreated: ERROR");
                            Toast.makeText(getContext(),"Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
            rvTvShow.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            rvTvShow.setHasFixedSize(true);
            rvTvShow.setAdapter(tvShowAdapter);
        }
    }
}
