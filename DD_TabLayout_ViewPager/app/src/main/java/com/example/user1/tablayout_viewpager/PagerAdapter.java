package com.example.user1.tablayout_viewpager;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.user1.tablayout_viewpager.fragment.NormalFragment;
import com.example.user1.tablayout_viewpager.fragment.RecycleViewFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daffer on 2017/9/16.
 */



public class PagerAdapter
        extends FragmentStatePagerAdapter
{


    private Activity activity;
    private List<Fragment> fragments;


    public PagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<Fragment>();
        fragments.add(RecycleViewFragment.newInstance());
    }


    @Override
    public int getCount() {
        return fragments.size();
    }



    @Override
    public Fragment getItem(int position) {     //生成Fragment

            return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {    //生成Tab標題
        String page = position+1+"";
        return "Tab "+ page;
    }

    //================================================
    public void addPage(){
        fragments.add(NormalFragment.newInstance(fragments.size()));
        notifyDataSetChanged();
    }

    public void removePage(){
        if(fragments.size()>1) fragments.remove(1);
        notifyDataSetChanged();
    }

    void autoGenerate(int num){       //產生新的VierPager內容物件
        for(int i=1; i<=num;i++){
            fragments.add(NormalFragment.newInstance(i));
        }
        notifyDataSetChanged();
    }

}
