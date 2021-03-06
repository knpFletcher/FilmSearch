package com.karenpownall.android.aca.filmsearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> mMovieList;
    private LayoutInflater mInflater;
    private Context mContext;

    public MoviesAdapter (Context context){
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMovieList = new ArrayList<>();
    }

    @Override
    public MovieViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.row_movie, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = mMovieList.get(position);

        //this is how we use Picasso to load images from the internet
        Picasso.with(mContext)
                .load(movie.getPoster())
                .placeholder(R.color.colorAccent)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return (mMovieList == null) ? 0 : mMovieList.size();
        //ternary operator
        //doing same thing as if/else statement in one line
    }

    public void setMovieList(List<Movie> movieList){
        //clear out 1st, start fresh
        this.mMovieList.clear();
        this.mMovieList.addAll(movieList);
        //adapter needs to know movieList has changed
        //if not called, app will crash
        notifyDataSetChanged();
    }

    public List<Movie> getMovieList(){
        return mMovieList;
    }


}
