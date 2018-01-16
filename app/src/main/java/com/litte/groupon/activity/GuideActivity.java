package com.litte.groupon.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.litte.groupon.R;
import com.litte.groupon.adapter.MyFragmentPagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends FragmentActivity {
    MyFragmentPagerAdapter adapter = null;
    @BindView(R.id.guide_viewPager)
    ViewPager guide_viewPager;
    @BindView(R.id.circlePageIndicator)
    CirclePageIndicator circlePageIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        initUI();
        setListener();
    }


    private void initUI() {
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        guide_viewPager.setAdapter(adapter);
        circlePageIndicator.setViewPager(guide_viewPager);
        final float density = getResources().getDisplayMetrics().density;
//        circlePageIndicator.setBackgroundColor(0xFFCCCCCC);
        circlePageIndicator.setRadius(10 * density);
        circlePageIndicator.setPageColor(0xFFFFFFFF);
        circlePageIndicator.setFillColor(0xFFFF6633);
        circlePageIndicator.setStrokeColor(0xFFFF6633);
        circlePageIndicator.setStrokeWidth(2 * density);
    }
    private void setListener() {
        guide_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 3){
                    circlePageIndicator.setVisibility(View.INVISIBLE);
                }else {
                    circlePageIndicator.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
