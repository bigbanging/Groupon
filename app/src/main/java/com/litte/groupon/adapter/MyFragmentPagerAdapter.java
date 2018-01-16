package com.litte.groupon.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.litte.groupon.fragment.FirstFragment;
import com.litte.groupon.fragment.FourFragment;
import com.litte.groupon.fragment.SecondFragment;
import com.litte.groupon.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by litte on 2018/1/15.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments = null;
    public void addFragment(Fragment fragment){
        if (fragment!=null){
            fragments.add(fragment);
            notifyDataSetChanged();
        }
    }

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThirdFragment());
        fragments.add(new FourFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
