package com.litte.groupon.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

import com.litte.groupon.activity.MainActivity;

/**
 * Created by litte on 2018/1/16.
 */

public abstract class BaseFragment extends Fragment {
    public void skip(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
            }
        });
    }
}
