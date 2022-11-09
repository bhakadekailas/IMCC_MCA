package com.kb.adapterdemo.array_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kb.adapterdemo.R;

import java.util.ArrayList;
import java.util.List;

public class MyCustomArrayAdapter extends ArrayAdapter<MovieDataModel> {
    private final Context myContext;
    private final List<MovieDataModel> moviesList;

    public MyCustomArrayAdapter(Context context, ArrayList<MovieDataModel> moviesList) {
        super(context, 0, moviesList);
        this.myContext = context;
        this.moviesList = moviesList;
    }

    @Override
    public int getCount() {
        return moviesList.size();
    }


    @Override
    public MovieDataModel getItem(int position) {
        return moviesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(myContext).inflate(R.layout.row_my_array_adapter, parent, false);
        }


        MovieDataModel movieDataModel = moviesList.get(position);
        TextView textViewMovieName = convertView.findViewById(R.id.textViewMovieName);
        textViewMovieName.setText(movieDataModel.getMovieName());

        TextView textViewReleaseDate = convertView.findViewById(R.id.textViewReleaseDate);
        textViewReleaseDate.setText(movieDataModel.getReleaseDate());

        TextView textViewRating = convertView.findViewById(R.id.textViewRating);
        textViewRating.setText(String.valueOf(movieDataModel.getRating()));

        return convertView;
    }
}
