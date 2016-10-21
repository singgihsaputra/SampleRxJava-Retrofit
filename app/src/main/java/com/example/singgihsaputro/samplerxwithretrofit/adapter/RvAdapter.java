package com.example.singgihsaputro.samplerxwithretrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.singgihsaputro.samplerxwithretrofit.R;
import com.example.singgihsaputro.samplerxwithretrofit.data.entity.MovieEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singgihsaputro on 10/18/16.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    List<MovieEntity.Results> mItems;

    public RvAdapter() {
        super();
        mItems = new ArrayList<MovieEntity.Results>();
    }

   public void addData(List<MovieEntity.Results> movie) {
        mItems = movie;
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        MovieEntity.Results movie = mItems.get(i);
        viewHolder.login.setText(movie.getOriginal_title());
        viewHolder.repos.setText("rating: " + movie.getVote_average());
        viewHolder.blog.setText("date: " + movie.getRelease_date());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView login;
        public TextView repos;
        public TextView blog;

        public ViewHolder(View itemView) {
            super(itemView);
            login = (TextView) itemView.findViewById(R.id.login);
            repos = (TextView) itemView.findViewById(R.id.repos);
            blog = (TextView) itemView.findViewById(R.id.blog);
        }
    }
}
