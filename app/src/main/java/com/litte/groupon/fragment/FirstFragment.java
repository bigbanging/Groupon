package com.litte.groupon.fragment;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.litte.groupon.R;
import com.litte.groupon.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends BaseFragment {


    @BindView(R.id.textView_first_jump_over)
    TextView textView_jump_over;
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this,view);
        skip(textView_jump_over);
        return view;
    }

}
