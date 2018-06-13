package com.example.charl.gamingnewz.Activities.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.charl.gamingnewz.Activities.Fragments.MainNews;
import com.example.charl.gamingnewz.Activities.Fragments.TabbedFragment;

import java.util.ArrayList;
import java.util.List;

public class NewsViewPagerAdapter  extends FragmentPagerAdapter {






    public NewsViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }


}
