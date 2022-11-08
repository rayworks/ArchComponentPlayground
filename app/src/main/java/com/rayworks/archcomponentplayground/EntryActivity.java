package com.rayworks.archcomponentplayground;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Sean on 1/30/18.
 */

public class EntryActivity extends ListActivity {
    private Map<String, Class> map;
    private ArrayList<String> strings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_layout);

        map = new TreeMap<>();
        map.put("Activity with ViewModel inside", MainActivity.class);
        map.put("Activity with retained Fragment", CounterActivity.class);


        strings = new ArrayList<>();
        strings.addAll(map.keySet());

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                strings));

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EntryActivity.this, map.get(strings.get(position)));
                startActivity(intent);
            }
        });
    }
}
