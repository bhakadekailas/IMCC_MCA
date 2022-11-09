package com.kb.adapterdemo.base_adapters;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.kb.adapterdemo.R;

import java.util.ArrayList;

public class MyBaseAdapterActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_base_adapter);
        listView = findViewById(R.id.listView);
        ArrayList<CountryDataModel> itemsArrayList = generateItemsList();
        MyCustomBaseAdapter adapter = new MyCustomBaseAdapter(this, itemsArrayList);
        listView.setAdapter(adapter);
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