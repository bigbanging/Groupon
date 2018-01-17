package com.litte.groupon.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.litte.groupon.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 进入主见面的设计
 */
public class MainActivity extends Activity {

    //头部控件
    @BindView(R.id.ll_choose_city)
    LinearLayout ll_choose_city;
    @BindView(R.id.main_title_textView_position)
    TextView main_title_textView_position;//显示城市
    @BindView(R.id.main_title_imageView_select_position)
    ImageView main_title_imageView_select_position;//城市的下拉按钮
    @BindView(R.id.ll_search)
    LinearLayout ll_search;
    @BindView(R.id.main_title_textView_search)
    TextView main_title_textView_search;//搜索框
    @BindView(R.id.main_title_imageView_add_icon)
    ImageView main_title_imageView_add_icon;//add图片
    @BindView(R.id.menu_layout)
    View menu_layout;
    //中部控件
    @BindView(R.id.pullToRefreshListView_main)
    PullToRefreshListView pullToRefreshListView;

    ListView listView;
    List<String> datas = null;
    ArrayAdapter<String> adapter = null;
    //底部控件
    @BindView(R.id.radioGroup_bottom)
    RadioGroup radioGroup_bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initialListView();
    }

    private void initialListView() {
        listView = pullToRefreshListView.getRefreshableView();
        datas = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,datas);
        //为listView添加内容布局
        LayoutInflater inflater = LayoutInflater.from(this);
        View listHeaderIcons = inflater.inflate(R.layout.main_header_icon_layout,listView,false);
        View listHeaderAddAct = inflater.inflate(R.layout.main_header_adds_act,listView,false);
        View listHeaderAddList = inflater.inflate(R.layout.main_header_list_ads,listView,false);
        View listHeaderThird = inflater.inflate(R.layout.main_header_third_part,listView,false);
        listView.addHeaderView(listHeaderIcons);
        listView.addHeaderView(listHeaderAddAct);
        listView.addHeaderView(listHeaderThird);
        listView.addHeaderView(listHeaderAddList);
        listView.setAdapter(adapter);
        initialListHeaderIcons(listHeaderIcons);

        //添加下拉松手后的刷新
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        datas.add(0,"新增数据");
                        refresh();
                        pullToRefreshListView.onRefreshComplete();
                    }
                },1000);
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                /*Log.i("TAG", "onScrollStateChanged: 开始滚动");
                Log.i("TAG", "onScrollStateChanged: 第一个参数AbsListView view:"+view);
                Log.i("TAG", "onScrollStateChanged: 第二个参数firstVisibleItem:"+firstVisibleItem);
                Log.i("TAG", "onScrollStateChanged: 第三个参数visibleItemCount:"+visibleItemCount);
                Log.i("TAG", "onScrollStateChanged: 第四个参数totalItemCount:"+totalItemCount);*/
                if (firstVisibleItem==0){
                    main_title_textView_position.setVisibility(View.VISIBLE);
                    main_title_imageView_select_position.setVisibility(View.VISIBLE);
                    main_title_imageView_add_icon.setVisibility(View.VISIBLE);
                }else {
                    main_title_textView_position.setVisibility(View.GONE);
                    main_title_imageView_select_position.setVisibility(View.GONE);
                    main_title_imageView_add_icon.setVisibility(View.GONE);
                }
            }
        });
    }

    private void initialListHeaderIcons(View listHeaderIcons) {
        final ViewPager viewPager_main_header_icon = listHeaderIcons.findViewById(R.id.viewPager_main_header_icon);
        PagerAdapter adapter = new PagerAdapter() {
            int[] resIds = new int[]{
                    R.layout.main_header_icon_one,
                    R.layout.main_header_icon_two,
                    R.layout.main_header_icon_three
            };
            @Override
            public int getCount() {
                return 30000;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                int layoutId = resIds[position%3];
                View view = LayoutInflater.from(MainActivity.this).inflate(layoutId,viewPager_main_header_icon,false);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        };
        viewPager_main_header_icon.setAdapter(adapter);
        viewPager_main_header_icon.setCurrentItem(15000);
        final ImageView imageView_banner_pot_1 = listHeaderIcons.findViewById(R.id.imageView_left);
        final ImageView imageView_banner_pot_2 = listHeaderIcons.findViewById(R.id.imageView_center);
        final ImageView imageView_banner_pot_3 = listHeaderIcons.findViewById(R.id.imageView_right);
        viewPager_main_header_icon.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                imageView_banner_pot_1.setImageResource(R.drawable.banner_dot);
                imageView_banner_pot_2.setImageResource(R.drawable.banner_dot);
                imageView_banner_pot_3.setImageResource(R.drawable.banner_dot);
                switch (position%3){
                    case 0:
                        imageView_banner_pot_1.setImageResource(R.drawable.banner_dot_pressed);
                        break;
                    case 1:
                        imageView_banner_pot_2.setImageResource(R.drawable.banner_dot_pressed);
                        break;
                    case 2:
                        imageView_banner_pot_3.setImageResource(R.drawable.banner_dot_pressed);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    private void refresh() {
        datas.add("aaa");
        datas.add("bbb");
        datas.add("ccc");
        datas.add("ddd");
        datas.add("eee");
        datas.add("fff");
        datas.add("ggg");
        datas.add("hhh");
        datas.add("iii");
        datas.add("jjj");
        datas.add("kkk");
        adapter.notifyDataSetChanged();
    }
    @OnClick(R.id.main_title_textView_position)
    public void jumpToCityChoose(View view){
        startActivity(new Intent(this,CityChooseActivity.class));
    }
    @OnClick(R.id.main_title_imageView_add_icon)
    public void toggleMenu(View view){
        if (menu_layout.getVisibility() == View.VISIBLE){
            menu_layout.setVisibility(View.INVISIBLE);
        }else {
            menu_layout.setVisibility(View.VISIBLE);
        }
    }
}
