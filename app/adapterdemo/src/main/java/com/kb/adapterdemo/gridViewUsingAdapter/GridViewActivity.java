package com.kb.adapterdemo.gridViewUsingAdapter;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

import com.kb.adapterdemo.R;
import com.kb.adapterdemo.base_adapters.CountryDataModel;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gridView = findViewById(R.id.gridView);
        ArrayList<CountryDataModel> itemsArrayList = generateItemsList();
        MyCustomAdapterForGridView adapter = new MyCustomAdapterForGridView(this, itemsArrayList);
        gridView.setAdapter(adapter);
    }

    private ArrayList<CountryDataModel> generateItemsList() {
        ArrayList<CountryDataModel> arrayList = new ArrayList<>();
        arrayList.add(new CountryDataModel("India", 91));
        arrayList.add(new CountryDataModel("Pakistan", 81));
        arrayList.add(new CountryDataModel("Japan", 72));
        arrayList.add(new CountryDataModel("UK", 11));
        arrayList.add(new CountryDataModel("US", 77));
        arrayList.add(new CountryDataModel("China", 80));
        arrayList.add(new CountryDataModel("India", 91));
        arrayList.add(new CountryDataModel("Pakistan", 81));
        arrayList.add(new CountryDataModel("Japan", 72));
        arrayList.add(new CountryDataModel("UK", 11));
        arrayList.add(new CountryDataModel("US", 77));
        arrayList.add(new CountryDataModel("China", 80));
        return arrayList;
    }
}