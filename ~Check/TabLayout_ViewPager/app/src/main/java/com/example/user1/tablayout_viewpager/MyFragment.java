package com.example.user1.tablayout_viewpager;

/**
 * Created by user1 on 2017/2/2.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment extends Fragment {


    private static final String MESSAGE ="MESSAGE";

    private String position;


    public static MyFragment newInstance(int position) {
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MESSAGE,position+1+"");
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getString(MESSAGE,"");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.my_fragment, container, false);

        TextView message =(TextView)view.findViewById(R.id.message);
        message.setText("Fragment Page: "+ position);


        return view;
    }
}
