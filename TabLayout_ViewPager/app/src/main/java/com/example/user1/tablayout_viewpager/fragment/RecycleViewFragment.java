package com.example.user1.tablayout_viewpager.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user1.tablayout_viewpager.R;
import com.example.user1.tablayout_viewpager.recyclerview.RecyclerViewAdapter;

public class RecycleViewFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private Activity activity;


    public static RecycleViewFragment newInstance() {
        RecycleViewFragment recycleViewFragment = new RecycleViewFragment();
        Bundle bundle = new Bundle();

        recycleViewFragment.setArguments(bundle);
        return recycleViewFragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recycleview, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(activity);

        recyclerView.setAdapter(adapter);
        return view;
    }
}

