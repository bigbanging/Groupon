package com.litte.groupon.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.litte.groupon.R;
import com.litte.groupon.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FourFragment extends BaseFragment {


    @BindView(R.id.guide_four_button)
    Button guide_four_over_button;
    public FourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        ButterKnife.bind(this,view);
        skip(guide_four_over_button);
        return view;
    }
}
