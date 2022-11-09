package com.kb.adapterdemo.photoGalleryUsingAdapter;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

import com.kb.adapterdemo.R;

import java.util.ArrayList;

public class PhotoGalleryActivity extends AppCompatActivity {
    GridView gridViewForPhotoGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);
        gridViewForPhotoGallery = findViewById(R.id.gridViewForPhotoGallery);

        ArrayList<CollegeInfoDataModel> arrayList = loadCollegeList();

        MyPhotoGalleryAdapter myPhotoGalleryAdapter = new MyPhotoGalleryAdapter(PhotoGalleryActivity.this, arrayList);
        gridViewForPhotoGallery.setAdapter(myPhotoGalleryAdapter);
    }

    private ArrayList<CollegeInfoDataModel> loadCollegeList() {
        ArrayList<CollegeInfoDataModel> arrayList = new ArrayList<>();
        arrayList.add(new CollegeInfoDataModel(R.drawable.imcc, "IMCC"));
        arrayList.add(new CollegeInfoDataModel(R.drawable.fc, "FC"));
        arrayList.add(new CollegeInfoDataModel(R.drawable.modern, "MODERN"));
        arrayList.add(new CollegeInfoDataModel(R.drawable.mit, "MIT"));
        arrayList.add(new CollegeInfoDataModel(R.drawable.imcc, "IMCC"));
        arrayList.add(new CollegeInfoDataModel(R.drawable.imcc, "IMCC"));
        arrayList.add(new CollegeInfoDataModel(R.drawable.fc, "FC"));
        arrayList.add(new CollegeInfoDataModel(R.drawable.modern, "MODERN"));
        arrayList.add(new CollegeInfoDataModel(R.drawable.mit, "MIT"));
        arrayList.add(new CollegeInfoDataModel(R.drawable.imcc, "IMCC"));
        return arrayList;
    }
}