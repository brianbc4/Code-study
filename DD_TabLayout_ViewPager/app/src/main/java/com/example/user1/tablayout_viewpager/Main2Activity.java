package com.example.user1.tablayout_viewpager;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.user1.tablayout_viewpager.ItemTouchHelper.SimpleItemTouchHelperCallback;
import com.example.user1.tablayout_viewpager.recyclerview.TestAdapter;

import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {


    RecyclerView recyclerView;
    TestAdapter adapter;
    ItemTouchHelper itemTouchHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new TestAdapter(this, Arrays.asList(getResources().getStringArray(R.array.items)));
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    public static void startActivity(Activity activity){
        activity.startActivity(new Intent(activity, Main2Activity.class));
    }
}
