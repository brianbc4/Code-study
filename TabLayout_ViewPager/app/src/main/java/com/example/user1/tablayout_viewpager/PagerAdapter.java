package com.example.user1.tablayout_viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daffer on 2017/9/16.
 */



public class PagerAdapter extends FragmentStatePagerAdapter {


    private List<Fragment> fragments;


    public PagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }


    @Override
    public int getCount() {
        return fragments.size();
    }


    @Override
    public Fragment getItem(int position) {
//        return fragments.get(position);
        return MyFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String page = position+1+"";
        return "Tab "+ page;
    }

    //================================================
    public void addPage(){
        fragments.add(MyFragment.newInstance(fragments.size()+1));
        notifyDataSetChanged();
    }

    public void removePage(){
        if(fragments.size()>1) fragments.remove(1);
        notifyDataSetChanged();
    }

    void autoGenerate(int num){
        for(int i=1; i<=num;i++){
            fragments.add(MyFragment.newInstance(i));
        }
        notifyDataSetChanged();
    }

}
