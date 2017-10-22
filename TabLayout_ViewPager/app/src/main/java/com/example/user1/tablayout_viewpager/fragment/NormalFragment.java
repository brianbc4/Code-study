package com.example.user1.tablayout_viewpager.fragment;

/**
 * Created by user1 on 2017/2/2.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user1.tablayout_viewpager.R;

public class NormalFragment
        extends Fragment
{


    private static final String MESSAGE ="MESSAGE";

    private String position;


    public static NormalFragment newInstance(int position) {
        NormalFragment normalFragment = new NormalFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MESSAGE,position+1+"");
        normalFragment.setArguments(bundle);
        return normalFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getString(MESSAGE,"");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_normal, container, false);

        TextView message =(TextView)view.findViewById(R.id.message);
        message.setText("Fragment Page: "+ position);


        return view;
    }
}
