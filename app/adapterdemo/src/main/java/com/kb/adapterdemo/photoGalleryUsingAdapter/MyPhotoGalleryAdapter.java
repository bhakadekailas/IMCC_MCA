package com.kb.adapterdemo.photoGalleryUsingAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kb.adapterdemo.R;

import java.util.ArrayList;

public class MyPhotoGalleryAdapter extends BaseAdapter {
    ArrayList<CollegeInfoDataModel> collegeList;
    Context context;

    public MyPhotoGalleryAdapter(Context context, ArrayList<CollegeInfoDataModel> collegeList) {
        this.context = context;
        this.collegeList = collegeList;
    }

    @Override
    public int getCount() {
        return collegeList.size();
    }

    @Override
    public Object getItem(int position) {
        return collegeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.row_photo_gallery, viewGroup, false);
        }
        CollegeInfoDataModel collegeInfoDataModel = collegeList.get(position);

        ImageView imageViewForCollege = view.findViewById(R.id.imageViewForCollege);
        imageViewForCollege.setImageResource(collegeInfoDataModel.getImagePath());

        TextView textViewForCollegeName = view.findViewById(R.id.textViewForCollegeName);
        textViewForCollegeName.setText(collegeInfoDataModel.getCollegeName());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, collegeInfoDataModel.getCollegeName(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
